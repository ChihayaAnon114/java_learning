package d12;

//目前这些查询依赖表格的结构，不能更改表格的列名类型等
import java.sql.*;
import java.util.Map;
import java.util.TreeMap;

public class DQL {
    public static Map<Integer,QueryResult> operateQuery(Connection conn,String sql) {
        //基本查询方法，返回序号与其他信息对应的map
        //不需要接入table name，因为表名等已经在sql语句中了
        PreparedStatement pmst = null;
        ResultSet rs = null;
        Map<Integer, QueryResult> query_res = new TreeMap<>();
        try {
            pmst = conn.prepareStatement(sql);
            rs = pmst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                String regdate = String.valueOf(rs.getTimestamp("regdate"));
                QueryResult r=new QueryResult(id,name,password,regdate);
                query_res.put(id,r);
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
    public static Map<Integer, QueryResult> operateQuery(
            Connection conn,
            String sql,
            Object... params
    ) throws SQLException {

        PreparedStatement pmst = null;
        ResultSet rs = null;
        Map<Integer, QueryResult> query_res = new TreeMap<>();
        pmst = conn.prepareStatement(sql);
        rs = pmst.executeQuery();

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            // 1. 绑定参数（从 1 开始）
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }

            // 2. 执行查询（注意：没有 sql 参数）
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                String regdate = String.valueOf(rs.getTimestamp("regdate"));
                QueryResult r=new QueryResult(id,name,password,regdate);
                query_res.put(id,r);
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


    public static Map<Integer,QueryResult> queryAll(Connection conn,String tablename){
        //不打印的全部查询方法，返回序号与其他信息对应的map
        String sql = "select * from "+tablename;
        PreparedStatement pmst = null;
        ResultSet rs = null;
        Map<Integer, QueryResult> query_res = new TreeMap<>();
        try {
            pmst = conn.prepareStatement(sql);
            rs = pmst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                String regdate = String.valueOf(rs.getTimestamp("regdate"));
                QueryResult r=new QueryResult(id,name,password, regdate);
                query_res.put(id,r);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return query_res;
    }

    public static boolean existsById(Connection conn, String tableName, int id)
            throws SQLException {
        //判断是否存在某数据
        String sql = "SELECT * FROM " + tableName + " WHERE id = " + id + " LIMIT 1;";

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
    public static Map<Integer,QueryResult> queryById(Connection conn,String tablename,int id){
        String sql="SELECT * from " +tablename+"where id = "+id+";";
        try {
            Map<Integer, QueryResult> result=operateQuery(conn,sql);
            if (result.isEmpty()){
                System.out.println("record not existed");
                return null;
            }
            else return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static Map<Integer,QueryResult> queryByName(Connection conn,String tablename,String name){
        String sql = "SELECT * FROM " + tablename + " WHERE name = '" + name + "';";
        try {
            Map result=operateQuery(conn,sql);
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
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void printAll(Connection conn,String tablename) throws SQLException {
        //打印全表的方法
        String sql="select * from "+tablename;
        try {
            printQuery(conn,sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static int count(Connection conn, String tableName) throws SQLException {
        //查询记录条数
        String sql = "SELECT COUNT(*) FROM " + tableName;
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            rs.next();
            return rs.getInt(1);
        }
    }
}