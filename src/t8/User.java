package t8;

import java.util.Objects;

public class User {
    /*
    1、创建User类，包含如下成员：
    1）私有属性username、password，默认构造方法，将用户名赋值为”admin”，密码赋值为”000000”，
    2）set和get方法，用来实现给用户名和密码赋值和输出，
    3）reg()，用来完成注册功能，有3个参数，分别用来接受用户名、密码和确认密码，判断用户名的长度必须在6位以上，
    密码和确认密码必须相同且在6-14位之间，若符合全部要求，则代表注册成功，
    为该类的两个属性赋值为参数传递过来的用户名和密码，并返回true，否则返回false
    4）login()，用来判断是否登录成功，有2个参数，分别用来接受等待登录的用户名、密码，
    根据该参数的值和已经注册的用户名、密码进行比对，如果相同，则表示登录成功，返回true，否则返回false
     */
    private String username;
    private String pwd;
    User(){
        username="admin";
        pwd="000000";
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public boolean reg(String username,String psw,String psw_1)
    {
        if (psw.length()>=6&&psw.length()<=14&&psw.equals(psw_1)){
            this.username=username;this.pwd=psw;
            return true;
        }
        else return false;
    }
    public boolean login(String username,String psw){
        return (Objects.equals(this.username, username) && Objects.equals(this.pwd, psw));
    }
}
