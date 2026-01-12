package d12.DBver_2;
import java.security.PublicKey;
import java.sql.Connection;

import static d12.DBver_2.DBUtilsBasis.connectToDB;
import static java.lang.Integer.parseInt;

public class UserRecord extends RecordLine {
    public static Connection conn;
    static {
        try {
            conn=connectToDB("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8","root","root");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //静态代码块，创建该类的时候就连接到数据库。
        //使用完毕需要手动关闭数据库连接
        //！新表名是usertable
    }

    //主键是ID，第二列是username，第三列是password，第四列是age，第5列是regdate，默认值为default，sql写入now()
    UserRecord() {
        col_num = 5;
        this.recordLine = new String[5];
        this.num = 0;
    }

    UserRecord(Integer id, String username, String psw, Integer age) {
        this();
        this.recordLine[0] = id.toString();
        this.num = id;
        this.mainKey = id.toString();
        this.recordLine[1] = username;
        this.recordLine[2] = psw;
        this.recordLine[3] = age.toString();
        this.recordLine[4] = "now()";
    }

    UserRecord(String username, String psw, Integer age) {
        this(DQLv2.queryMaxId(conn) + 1, username, psw, age);
    }
    public void setAge(Integer age){
        this.recordLine[3]=age.toString();
    }
    public void setAge(String age){
        this.recordLine[3]=age;
    }
    public void setPassword(String psw){
        this.recordLine[2]=psw;
    }
    public void setUsername(String username){
        this.recordLine[1]=username;
    }
    public void setID(String ID){
        this.recordLine[0]= ID;
        this.num= parseInt(ID);
        this.mainKey=ID;
    }
    public void setID(Integer ID){
        this.recordLine[0]= ID.toString();
        this.num= ID;
        this.mainKey=ID.toString();
    }
    public Integer getID(){
        return this.num;
    }
    public String getUsername(){
        return this.recordLine[1];
    }
    public String getAge(){
        return this.recordLine[3];
    }
    public Integer getAgeInt(){
        return parseInt(getAge());
    }
    public String getPassword(){
        return recordLine[2];
    }
    public Boolean examePassword(String psw){
        return this.recordLine[2].equals(psw);
    }
    }