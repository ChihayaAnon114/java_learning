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
