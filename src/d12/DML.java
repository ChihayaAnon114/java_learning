package d12;

import java.sql.*;

import static d12.DbUtils.operateDB;

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
        if (!DQL.existsById(conn,tablename,id)){
            System.out.println("Record not existed");
        }else {
            String sql="update "+tablename+" set name="+name+",password= "+password+",regdate=now() where id="+id+";";
            operateDB(conn,sql);
            DQL.printQuery();
        }
    }


}
