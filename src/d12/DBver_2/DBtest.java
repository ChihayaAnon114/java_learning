package d12.DBver_2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;

import static d12.DBver_2.DMLv2.clearTable;
import static d12.DBver_2.DMLv2.insertDB;
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
        //随机生成50条记录
        Connection conn= connectToDB("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8","root","root");
        clearTable(conn,"usertable");
        Random r=new Random();
        for (int i = 0; i < 50; i++) {
            String sql=null;
            UserRecord rec=new UserRecord(i+5,randomLetters(10),randomNums(12),r.nextInt(40)+20);
            insertDB(conn,rec);
        }
        printQuery(conn,"SELECT * FROM usertable");

        connClose(conn);
    }
}
