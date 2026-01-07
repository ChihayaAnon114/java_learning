package d12.DBver_2;

import d12.DQL;
import d12.QueryResult;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import static d12.DbUtils.operateDB;

//Connection conn= connectToDB("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8","root","root");
public class DMLv2 {
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


    public static void insertDB(Connection conn,UserRecord record) throws SQLException {
        //插入新记录
        String sql = "INSERT INTO usertable VALUES (DEFAULT, '" + record.getUsername() + "', '" + record.getPassword() +"', '" +record.getAge()+ "', NOW())";

        try {
            operateDB(conn,sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void deleteById(Connection conn,int id){
        //删除一个指定记录
        String sql="DELETE FROM usertable WHERE id ="+id;
        try {
            operateDB(conn,sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateById(Connection conn,Integer id,UserRecord newrecord) throws SQLException {
        //根据id修改记录
        if (!DQL.existsById(conn,"usertable",id)){
            System.out.println("Record not existed");
        }else {
            String sql = "UPDATE usertable SET name = '" + newrecord.getUsername() + "', password = '" + newrecord.getPassword()
                    +"', age = '"+newrecord.getAge()+ "', regdate = NOW()" + " WHERE id = " + id + ";";

            operateDB(conn,sql);
//            System.out.println(DQL.queryById(conn,tablename,id));
        }
    }
    public static void updateByName(Connection conn,String tablename,String name,UserRecord newrecord) throws SQLException {
        //根据名字修改记录
        if (!DQL.existsByName(conn,tablename,name)){
            System.out.println("Record not existed");
            insertDB(conn,newrecord);
        }else {

            UserRecord existed=DQLv2.queryByName(conn,name).get(0);
                    //在字典中查询到的第一个对象
            Integer id= existed.getID();
            updateById(conn,id,newrecord);
        }
    }
}
