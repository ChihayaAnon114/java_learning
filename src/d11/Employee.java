package d11;
import java.util.Random;
public class Employee {
    //1、向文件employee.txt中写入200条员工的信息，每条信息包括员工的姓名、年龄、性别、工资，
    // 这些信息均调用自定义函数随机产生，每条信息独立一行，自定义函数要求如下：
    //1）函数getName()：返回随机产生的姓名。定义一个长度为8的字符串数组，存储姓氏，
    // 再定义一个长度为10的字符串数组，存储名，随机产生两个数组的下标，获取两个数组中的姓和名，组成一个姓名并返回
    //2）函数getAge()：返回随机产生的年龄。要求年龄在18-60岁之间
    //3）函数getSex()：返回随机产生的性别。要求只能返回男或者女
    //4）函数getScore()：返回随机产生的工资。要求工资在1000-4000元之间

    public static Integer getAge(){
        Random r=new Random();
        return (r.nextInt(42)+18);
    }
    public static String getletter(int n) {
        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random r = new Random();
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            sb.append(letters.charAt(r.nextInt(letters.length())));
        }
        return sb.toString();
    }
    public static String getName(){
        StringBuffer name=new StringBuffer();
        name.append(getletter(8));name.append(' ');name.append(getletter(10));
        return name.toString();
    }
    public static int get_gender(){
        Random r=new Random();
        return r.nextInt(2);//0 male, 1 female
    }
    public static int get_salary(){
        Random r=new Random();
        return r.nextInt(3001)+1000;
    }
    public String name=null;
    public String gender;
    public int salary;
    public int age;
    Employee(){
        this.name=getName();
        this.age=getAge();
        this.salary=get_salary();
        if (get_gender()==0)
            this.gender="M";
        else this.gender="F";
    }

    @Override
    public String toString() {
        return name + ": gender: " + gender  + ", salary: " + salary + ", age=" + age;
    }
}
