package d6;
import java.util.Scanner;

public class t5 {
    /*
    3．创建类TestStudent，包含main()，完成如下功能
    a)创建一个Student类对象，调用默认构造方法为属性初始化，显示出该学生的信息，显示效果为：
    学生***，性别为男，出生日期是：1990-4-10

    创建类TestStudent，创建一个Student对象，调用带参数的构造方法为属性赋值，
    传递的参数通过控制台输入获取，要求控台输入学生的名字、性别、年、月、日。显示出该学生的信息
     */
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        Student stu1=new Student();
        System.out.println("name:");
        String n=inp.next();
        System.out.println("gender:");
        String g=inp.next();
        System.out.println("birthdate:year");
        int y= inp.nextInt();
        System.out.println("birthdate:month");
        int m= inp.nextInt();
        System.out.println("birthdate:day");
        int d= inp.nextInt();
        Student stu2=new Student(n,g,y,m,d);
        stu1.show();
        stu2.show();
    }
}
    /*
    1．创建类Date，用来描述日期数据，包含成员如下
    a)private属性year、month、day，分别用来表示日期的年、月、日
    b)默认构造方法，给属性赋值为当前日期（根据今天的日期赋值即可）
    c)带参数的构造方法，根据参数给属性赋值
    d)public String showDate()：以字符串的方式返回由3个属性值组成的一个日期数据，年，月，日使用“-”间隔


    2．创建类Student，包含成员如下
    a)private属性：name、sex、birthday（该属性要求为Date类型）
    b)默认构造方法，为属性初始化为：“新同学”，性别为“未知”，生日为“1990-4-10”
    c)带有5个参数的构造方法，根据参数为属性赋值
    d)public void showMessage()，输出学生的所有信息。
     */