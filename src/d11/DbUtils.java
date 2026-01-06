package d11;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//TODO: 调用operateDB封装增删改/查询DQL操作为新方法，
// 修改关闭连接的方式，
// 修改query为pmst模式，增加无打印版本的查询
public class DbUtils {
    static {
        try {
            connectToDB("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8","root","root");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取Connection对象
     */
    public static Connection connectToDB(String className, String url, String user, String psw){
        //直接连接数据库
        //类创建时自动连接了这个数据库，因此不需要手动连接了
        Connection conn = null;
        try {
            //加载jdbc驱动
            Class.forName(className);
            conn = DriverManager.getConnection(url,
                    user,
                    psw);
            if(conn!=null){
                System.out.println("CONNECTED");
            }
            else System.out.println("connection failed");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }


    public static void operateDB(Connection conn, String sql){
        //用于手动输入数据来执行数据库操作
        try (PreparedStatement pmst = conn.prepareStatement(sql)) {
            int res = pmst.executeUpdate();
            if (res > 0) {
                System.out.println(" add success");//检验操作是否完成

            }else System.out.println("add failed");
        } catch (SQLException e) {
            System.out.println("异常:" + e.getMessage());//当出现任何异常
        }
    }
    public static void connClose(Connection conn){
        //关闭连接
        try {
            conn.close();
            System.out.println("connect closed");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void printQuery(Connection conn, String sql) throws SQLException {
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            ResultSetMetaData md = rs.getMetaData();
            int cols = md.getColumnCount();

            // 打印表头
            for (int i = 1; i <= cols; i++) {
                System.out.print(md.getColumnLabel(i));
                if (i < cols) System.out.print("\t");
            }
            System.out.println();

            for (int i = 1; i <= cols; i++) {
                System.out.print("--------");
                if (i < cols) System.out.print("\t");
            }
            System.out.println();

            // 打印数据
            while (rs.next()) {
                for (int i = 1; i <= cols; i++) {
                    Object val = rs.getObject(i);
                    System.out.print(val == null ? "NULL" : val.toString());
                    if (i < cols) System.out.print("\t");
                }
                System.out.println();
            }
        }
    }

    public static void printQuery(Connection conn, String sql,int limit) throws SQLException {
        //输出表
        try (Statement st = conn.createStatement();//用于打开发送指令的窗口。
             ResultSet rs = st.executeQuery(sql)) //用于存储原始数据表格查询结果到rs变量
        {
            ResultSetMetaData md = rs.getMetaData();
            int cols = md.getColumnCount();
            for (int i = 1; i <= cols; i++) {
                System.out.print(md.getColumnLabel(i));//用于使用具体方法取出具体数据，列或者行名等
                if (i < cols) System.out.print("\t");
            }
            System.out.println();
            for (int i = 1; i <= cols; i++) {
                System.out.print("--------");
                if (i < cols) System.out.print("\t");
            }
            System.out.println();
            while (rs.next()) {
                for (int i = 1; i <= limit; i++) {
                    Object val = rs.getObject(i);//rs是表内的具体数据
                    //rs是一个引用类对象，本质上是一个指针，而这里的val则是从指针引用中取出了当前数据原始值
                    System.out.print(val == null ? "NULL" : val.toString());
                    if (i < cols) System.out.print("\t");
                }
                System.out.println();
            }
        }
    }

//    public static void query()

    public static void dropTable(Connection conn, String tableName) throws SQLException {
        //删除表
        String sql = "DROP TABLE " + tableName;
        operateDB(conn, sql);
    }
    public static void clearTable(Connection conn, String tableName) throws SQLException {
        //清空表
        String sql = "DELETE FROM " + tableName;
        operateDB(conn, sql);
    }
    public static boolean existsById(Connection conn, String tableName, int id)
            throws SQLException {
        //判断是否存在某数据
        String sql = "SELECT 1 FROM " + tableName + " WHERE id = " + id + " LIMIT 1";
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            return rs.next();
        }
    }

    public static int count(Connection conn, String tableName) throws SQLException {
        //返回记录条数
        String sql = "SELECT COUNT(*) FROM " + tableName;
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            rs.next();
            return rs.getInt(1);
        }
    }

    public static void main(String[] args) {
        Connection conn= connectToDB("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8","root","root");
        operateDB(conn,"insert into tb_user values(default,'abc','10086',now())");
    }//无效的
}
