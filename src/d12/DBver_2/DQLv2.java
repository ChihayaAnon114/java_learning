package d12.DBver_2;
import d12.QueryResult;
import static java.lang.Integer.parseInt;
import java.sql.*;
import java.util.Map;
import java.util.TreeMap;
public class DQLv2 {
    public static Map<Integer, UserRecord> operateQuery(Connection conn, String sql) {
        //基本查询方法，返回序号与其他信息对应的map
        //不需要接入table name，因为表名等已经在sql语句中了
        PreparedStatement pmst = null;
        ResultSet rs = null;
        Map<Integer, UserRecord> query_res = new TreeMap<>();
        try {
            pmst = conn.prepareStatement(sql);
            rs = pmst.executeQuery();
            int query_id =0;
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("username");
                String password = rs.getString("password");
                String age=rs.getString("age");
                UserRecord r=new UserRecord(id,name,password,parseInt(age));
                query_res.put(query_id,r);
                query_id++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            pmst.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return query_res;
        //返回结果：[序号（返回集的第几个），UserRecord对象]
    }
    public static Map<Integer, UserRecord> operateQuery(
            Connection conn,
            String sql,
            Object... params
    ) throws SQLException {

        PreparedStatement pmst = null;
        ResultSet rs = null;
        Map<Integer, UserRecord> query_res = new TreeMap<>();
        pmst = conn.prepareStatement(sql);
        rs = pmst.executeQuery();

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            // 1. 绑定参数（从 1 开始）
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            int query_num=0;

            // 2. 执行查询（注意：没有 sql 参数）
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("username");
                String password = rs.getString("password");
                String age=rs.getString("age");
                UserRecord r=new UserRecord(id,name,password,parseInt(age));
                query_res.put(query_num,r);
                query_num++;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            pmst.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return query_res;
    }


    public static Map<Integer,UserRecord> queryAll(Connection conn){
        //不打印的全部查询方法，返回序号与其他信息对应的map
        String sql = "select * from "+"usertable";
        PreparedStatement pmst = null;
        ResultSet rs = null;
        Map<Integer, UserRecord> query_res = new TreeMap<>();
        try {
            pmst = conn.prepareStatement(sql);
            rs = pmst.executeQuery();
            int query_id=0;
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("username");
                String password = rs.getString("password");
                String age=rs.getString("age");
                UserRecord r=new UserRecord(id,name,password,parseInt(age));
                query_res.put(query_id,r);
                query_id++;

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return query_res;
    }

    public static boolean existsById(Connection conn, int id)
            throws SQLException {
        //判断是否存在某数据
        String sql = "SELECT * FROM usertable WHERE id = " + id + " LIMIT 1;";

        try{
            return !operateQuery(conn, sql).isEmpty();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean existsByName(Connection conn, String tableName, String name)
            throws SQLException {
        //判断是否存在某数据
        String sql = "SELECT * FROM " + tableName+ " WHERE name = '" + name + "' LIMIT 1;";
        try{
            return !operateQuery(conn, sql).isEmpty();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static Map<Integer,UserRecord> queryById(Connection conn,int id){
        String sql="SELECT * from usertable where id = "+id+";";
        try {
            Map<Integer, UserRecord> result=operateQuery(conn,sql);
            if (result.isEmpty()){
                System.out.println("record not existed");
                return null;
            }
            else return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static Map<Integer,UserRecord> queryByName(Connection conn,String name){
        String sql = "SELECT * FROM usertable WHERE name = '" + name + "';";
        try {
            Map<Integer,UserRecord> result=operateQuery(conn,sql);
            if (result.isEmpty()){
                System.out.println("record not existed");
                return null;
            }
            else return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void printQuery(Connection conn, String sql) throws SQLException {
        //按照需求打印
        try (PreparedStatement st = conn.prepareStatement(sql);
             ResultSet rs = st.executeQuery()) {

            ResultSetMetaData md = rs.getMetaData();
            int cols = md.getColumnCount();

            // 打印表头
            for (int i = 1; i <= cols; i++) {
                System.out.print(md.getColumnLabel(i));
                if (i < cols) System.out.print("\t   ");
            }
            System.out.println();

//            for (int i = 1; i <= cols; i++) {
//                System.out.print("--------");
//                if (i < cols) System.out.print("\t");
//            }
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
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void printAll(Connection conn) throws SQLException {
        //打印全表的方法
        String sql="select * from usertable";
        try {
            printQuery(conn,sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static int count(Connection conn) throws SQLException {
        //查询记录条数
        String sql = "SELECT COUNT(*) FROM usertable" ;
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            rs.next();
            return rs.getInt(1);
        }
    }
    public static Integer queryMaxId(Connection conn) {
        String sql = "SELECT COALESCE(MAX(CAST(ID AS UNSIGNED)), 0) AS max_id FROM usertable";
        //查询最大id以实现id递增
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                int maxId = rs.getInt("max_id");
                return rs.wasNull() ? 0 : maxId;
            }
            return 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
