package d12;

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
        //静态代码块，创建该类的时候就连接到数据库。
        //使用完毕需要手动关闭数据库连接
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
        //实际上相当于DML
        try (PreparedStatement pmst = conn.prepareStatement(sql)) {
            int res = pmst.executeUpdate();
            if (res > 0) {
                System.out.println(" add success");//检验操作是否完成

            }else System.out.println("add failed");
        } catch (SQLException e) {
            System.out.println("异常:" + e.getMessage());//当出现任何异常
        }
    }
    public static void connClose(Connection conn,PreparedStatement p,Statement s){
        //关闭连接
        try {
            conn.close();
            System.out.println("connect closed");
            if (p!=null)
                p.close();
            if (s!=null)
                s.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }//实际上在架构设计上，pmst在事务中均已经关闭，因此暂时并不需要
    }
    public static void connClose(Connection conn){
        //用于直接关闭连接
        try {
            conn.close();
            System.out.println("connect closed");
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
