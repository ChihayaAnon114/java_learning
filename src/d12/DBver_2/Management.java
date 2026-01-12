package d12.DBver_2;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
public class Management {
    Connection conn;
    Management() throws SQLException {
        conn=DBUtilsBasis.connectToDB("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8","root","root");
    }
    Management(Connection conn){
        this.conn=conn;
    }
    boolean register() throws SQLException {
        //从用户输入接收注册
        System.out.print("注册：\n姓名：");
        Scanner input=new Scanner(System.in);
        String name=input.next();
        System.out.print("年龄：");
        Integer age=input.nextInt();
        String psw;
        boolean flag=true;
        do {
            System.out.print("密码：");
            psw=input.next();
            System.out.print("确认密码：");
            if (input.next().equals(psw)){
                flag=false;
            }
            else {
                System.out.println("密码不同，请重新输入");
            }
        }while (flag);
        UserRecord user=new UserRecord(name,psw,age);
        DMLv2.insertDB(this.conn,user);
        Integer id=user.getID();
        System.out.println("注册成功，用户姓名"+name+"，账号id为"+id);
        return true;
    }
    boolean register(String name, String psw, Integer age) throws SQLException {
        UserRecord user=new UserRecord(name,psw,age);
        DMLv2.insertDB(this.conn,user);
        Integer id=user.getID();
        System.out.println("注册成功，用户姓名"+name+"，账号id为"+id);
        return true;
    }

    boolean delete_user(Integer id) throws SQLException {
        if(!DQLv2.existsById(this.conn,id)){
            System.out.println("数据不存在");
            return false;
        }
        else {
            DMLv2.deleteById(conn,id);
            if (Objects.requireNonNull(DQLv2.queryById(conn, id)).isEmpty()){
                System.out.println("删除成功");
                return true;}
                else {
                System.out.println("删除失败");
                return false;
            }
        }
    }
    List<UserRecord> show() throws SQLException {
        List<UserRecord>user_list=new ArrayList<>(DQLv2.queryAll(conn).values());
        DQLv2.printAll(conn);
        return user_list;
    }
    boolean login(Integer id,String pwd) throws SQLException {
        if (!DQLv2.existsById(conn,id)){
            System.out.println("用户不存在");
            return false;
        }
        else {
            if (!Objects.requireNonNull(DQLv2.queryById(conn, id)).get(0).examePassword(pwd)){
                System.out.println("密码错误");
                return false;
            }else {
                System.out.println("登录成功");
                return true;
            }
        }
    }
    public boolean login() throws SQLException {
        Scanner input=new Scanner(System.in);
        System.out.print("用户id：");
        Integer id= input.nextInt();
        System.out.print("用户密码：");
        String pwd=input.next();
        return login(id,pwd);
    }
}
