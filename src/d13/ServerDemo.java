package d13;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
public class ServerDemo {
    private static final int PORT = 8080;
    private static final int BUFFER_SIZE = 1024;
    // 存储所有客户端 Channel（线程安全）
    private static final ConcurrentHashMap<SocketChannel, String> clients = new
            ConcurrentHashMap<>();
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        /*
        一个 Selector 对象（事件分发器）:
        你会把很多 Channel 注册到它上面，并声明你关心哪些事件
        然后调用 selector.select()：线程会阻塞等待，直到某些 Channel “就绪”
        这样你不用自己遍历所有连接，也不用为每个连接开一个线程
         */
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        /*
        ServerSocketChannel（监听通道）
         */
        serverChannel.bind(new InetSocketAddress(PORT));//把监听通道绑定到本机某个端口（开始监听的前置条件）
        serverChannel.configureBlocking(false);//把监听通道设置为“非阻塞模式”
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);//把 serverChannel 登记到 selector 上，并声明你关心“接入事件”
        /*
        这里会创建一个 SelectionKey（可以理解为“注册凭证/门禁卡”），它记录了：
        这个 key 对应哪个 channel
        你关心哪些事件（interest set）
        现在是否就绪（ready set）
        SelectionKey.OP_ACCEPT 的含义是：
        “当有新的连接到来时，Selector 叫醒我。”
         */
        System.out.println("🚀 聊天室服务器启动，监听端口: " + PORT);
        while (true) {
            try {
// 阻塞等待事件（超时 1 秒防空转）
                if (selector.select(1000) == 0) continue;
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iter = keys.iterator();
                while (iter.hasNext()) {
                    SelectionKey key = iter.next();
                    iter.remove(); // ⚠️ 必须 remove，否则会重复处理
                    if (!key.isValid()) continue;
                    try {
                        if (key.isAcceptable()) {
                            handleAccept(serverChannel, selector);
                        } else if (key.isReadable()) {
                            handleRead(key, selector);
                        }
                    } catch (IOException e) {
                        System.err.println("处理事件时出错: " + e.getMessage());
                        closeChannel(key.channel());
                    }
                }
            } catch (IOException e) {
                System.err.println("Selector 出错: " + e.getMessage());
            }
        }
    }
    private static void handleAccept(ServerSocketChannel serverChannel, Selector
            selector) throws IOException {
        SocketChannel client = serverChannel.accept();
        if (client == null) return;
        client.configureBlocking(false);
        SelectionKey key = client.register(selector, SelectionKey.OP_READ);
// 生成唯一昵称
        String nick = "用户" + client.hashCode();
        clients.put(client, nick);
        System.out.println("✅ [" + nick + "] 加入聊天室，当前在线人数: " +
                clients.size());
// 欢迎消息 + 当前在线列表
        broadcast("📣 [" + nick + "] 进入聊天室", client); // 除自己外广播
        sendToClient(client, "欢迎你，" + nick + "！输入消息开始聊天（输入 'quit'退出）\n");
                sendToClient(client, "👥 当前在线: " + String.join(", ", clients.values())
                        + "\n");
    }
    private static void handleRead(SelectionKey key, Selector selector) throws
            IOException {
        SocketChannel client = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
        int bytesRead = client.read(buffer);
        if (bytesRead == -1) {
// 客户端断开
            handleClose(client);
            return;
        }
        if (bytesRead > 0) {
            buffer.flip();
            String msg = StandardCharsets.UTF_8.decode(buffer).toString();
// 按行分割（解决粘包：客户端发 "A\nB\n" 一次读到）
            String[] lines = msg.split("\n");
            String nick = clients.getOrDefault(client, "未知用户");
            for (String line : lines) {
                if (line.trim().isEmpty()) continue;
                if ("quit".equalsIgnoreCase(line.trim())) {
                    handleClose(client);
                    return;
                }
// 广播消息
                String fullMsg = "[" + nick + "]: " + line;
                System.out.println("📩 收到: " + fullMsg);
                broadcast(fullMsg, client); // 除发送者外广播
            }
        }
    }
    private static void broadcast(String msg, SocketChannel exclude) {
        msg += "\n";
        ByteBuffer buffer = StandardCharsets.UTF_8.encode(msg);
        for (SocketChannel ch : clients.keySet()) {
            if (ch != exclude && ch.isConnected()) {
                try {
// 写可能阻塞？实际 non-blocking 下若缓冲区满会返回 0，但此处简化
                    ch.write(buffer.duplicate()); // duplicate() 避免 position 冲
                } catch (IOException e) {
                    handleClose(ch);
                }
            }
        }
    }
    private static void sendToClient(SocketChannel client, String msg) {
        try {
            ByteBuffer buffer = StandardCharsets.UTF_8.encode(msg);
            client.write(buffer);
        } catch (IOException e) {
            handleClose(client);
        }
    }
    private static void handleClose(SocketChannel client) {
        String nick = clients.remove(client);
        if (nick != null) {
            System.out.println("❌ [" + nick + "] 退出聊天室，剩余人数: " +
                    clients.size());
            broadcast("📣 [" + nick + "] 离开聊天室", client);
        }
        closeChannel(client);
    }
    private static void closeChannel(Channel channel) {
        try {
            channel.close();
        } catch (IOException e) {
// ignore
        }
    }
}
/*
NIO TCP 服务器标准流程:
启动阶段（只做一次）
open Selector（建事件中心）
open ServerSocketChannel（建监听通道）
bind(port)（占住端口）
configureBlocking(false)（切非阻塞）
register(selector, OP_ACCEPT)（注册“接入事件”）

运行阶段（循环做）
selector.select()：阻塞等待事件发生
遍历 selectedKeys()：逐个处理就绪事件
如果是 ACCEPT：accept() 得到 SocketChannel
client.configureBlocking(false)
client.register(selector, OP_READ)（开始监听读事件）
如果是 READ：client.read(buffer) 读取数据并处理
 */