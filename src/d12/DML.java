package d12;

import java.sql.*;
import java.util.Objects;

import static d12.DbUtils.operateDB;
import static java.util.Objects.requireNonNull;
import static javax.swing.UIManager.get;

//TODO:修改记录方法
public class DML {
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


    public static void insertDB(Connection conn,String tablename,String name,String psw) throws SQLException {
        //插入新记录
        String sql="insert into "+tablename+" values(default, "+name+","+psw+",now())";
        try {
            operateDB(conn,sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void deleteById(Connection conn,String tablename,int id){
        //删除一个指定记录
        String sql="DELETE FROM "+tablename+"WHERE id ="+id;
        try {
            operateDB(conn,sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateById(Connection conn,String tablename,int id,String name, String password) throws SQLException {
        //根据id修改记录
        if (!DQL.existsById(conn,tablename,id)){
            System.out.println("Record not existed");
        }else {
            String sql="update "+tablename+" set name="+name+",password= "+password+",regdate=now() where id="+id+";";
            operateDB(conn,sql);
            System.out.println(DQL.queryById(conn,tablename,id));
        }
    }
    public static void updateByName(Connection conn,String tablename,String oldname,String newname, String password) throws SQLException {
        //根据名字修改记录
        if (!DQL.existsByName(conn,tablename,oldname)){
            System.out.println("Record not existed");
        }else {
            QueryResult queryRes= requireNonNull(DQL.queryByName(conn, tablename, oldname)).get(0);
            Integer id=queryRes.getId();
            updateById(conn,tablename,id,newname,password);
        }
    }
}
