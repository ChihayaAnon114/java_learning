package d13;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
public class ClientDemo {
    private static final String HOST = "localhost";
    private static final int PORT = 8080;
    public static void main(String[] args) {
        try (SocketChannel channel = SocketChannel.open()) {
            channel.connect(new InetSocketAddress(HOST, PORT));
            channel.configureBlocking(true); // 客户端用阻塞更简单
            System.out.println("💬 已连接聊天室，请输入消息（输入 'quit' 退出）：");
// 启动接收线程
            Thread readerThread = new Thread(() -> {
                ByteBuffer buffer = ByteBuffer.allocate(1024);
                try {
                    while (channel.isConnected()) {
                        int bytesRead = channel.read(buffer);
                        if (bytesRead == -1) break;
                        if (bytesRead > 0) {
                            buffer.flip();
                            String msg =
                                    StandardCharsets.UTF_8.decode(buffer).toString();
                            System.out.print("\r" + msg); // 覆盖输入行（简化）
                            buffer.clear();
                        }
                    }
                } catch (IOException e) {
                    System.out.println("⚠️ 连接中断");
                }
            });
            readerThread.setDaemon(true);
            readerThread.start();
// 主线程发送消息
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("➡️ ");
                String input = scanner.nextLine();
                if ("quit".equalsIgnoreCase(input)) {
                    channel.write(StandardCharsets.UTF_8.encode("quit\n"));
                    break;
                }
                if (!input.trim().isEmpty()) {
                    channel.write(StandardCharsets.UTF_8.encode(input + "\n"));
                }
            }
        } catch (IOException e) {
            System.err.println("❌ 连接失败: " + e.getMessage());
        }
        System.out.println("👋 已退出聊天室");
    }
}
/*
客户端启动阶段（只做一次）
Selector.open()建立事件中心
SocketChannel.open()创建客户端连接通道
configureBlocking(false)//配置为非阻塞
客户端要注册 Selector，也必须非阻塞
connect(serverAddress)，非阻塞 connect 可能不会立刻完成
register(selector, OP_CONNECT)关心“连接完成事件”

客户端运行阶段（循环）：
selector.select()
遍历 keys：
isConnectable()：说明 TCP 连接完成了
finishConnect() 结束连接流程
改注册为 OP_READ（开始等服务器消息）
isReadable()：服务器来消息了
read(buffer) → decode → 打印
 */