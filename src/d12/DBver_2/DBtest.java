package d12.DBver_2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;

import static d12.DBver_2.DMLv2.clearTable;
import static d12.DBver_2.DMLv2.insertDB;
import static d12.DQL.printAll;
import static d12.DQL.printQuery;
import static d12.DbUtils.*;

public class DBtest {
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
        Connection conn= connectToDB("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8","root","root");
        clearTable(conn,"usertable");
        Random r=new Random();Management m=new Management(conn);
        //手动注册
        m.register();
        for (int i = 0; i < 50; i++) {
            //随机生成50条记录
            m.register(randomLetters(10),randomLetters(10), r.nextInt(40)+20);
        }

        DMLv2.deleteById(conn,5);
        m.login();

        DQLv2.printAll(conn);
        connClose(conn);
    }
}
