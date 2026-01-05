package d11;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;
import static d11.DbUtils.*;

public class DataTest {


    public static String randomLetters(int n) {
        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random r = new Random();
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            sb.append(letters.charAt(r.nextInt(letters.length())));
        }
        return sb.toString();
    }
    public static String randomNums(int n) {
        String letters = "1234567890";
        Random r = new Random();
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            sb.append(letters.charAt(r.nextInt(letters.length())));
        }
        return sb.toString();
    }

    public static void main(String[] args) throws SQLException {
        //随机生成50条记录
        Connection conn= connectToDB("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8","root","root");
        clearTable(conn,"tb_user");
        for (int i = 0; i < 50; i++) {
            String sql=null;
            sql="insert into tb_user values(default,'"+randomLetters(5)+"','"+randomNums(10)+"',now())";
            operateDB(conn,sql);
        }
        printQuery(conn,"SELECT * FROM tb_user");

        connClose(conn);
    }
}
