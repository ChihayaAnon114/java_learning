package d6;
import java.util.Scanner;
/*
1）创建类Employee（员工类），包括如下成员：
私有的属性：员工姓名(name)、员工年龄(age)、员工职位(position)、工资(salary)
公有的默认构造方法：空方法
修改根据私有属性生成的get和set方法，具体要求如下：
年龄必须在18岁以上，当年龄无效时，将年龄强制赋值为18；
职位只能是“售后服务”和“销售员”，如果不符合要求，则强制将职位赋值为“售后服务”；
        工资根据员工的年龄段不同，具体要求：在原有工资基础上累加，18~20岁之间，加1000元，
        21~25岁之间，加1500元，26~30岁之间，加2000元，31~40岁之间，加3000元，41~50岁之间，加3500元，50岁以上, 加4000元
2）创建类TestEmployee，在该类中创建3个Employee对象，通过控制台输入给3个员工的名字、年龄、职位、薪资进行赋值，显示出所有员工的信息
 */
public class t2 {
    public static void main(String[] args) {
        Scanner inp =new Scanner(System.in);
        employee[] arrEmployee =new employee[3];
        for (int i = 0; i < 3; i++) {
            int ii=i+1;
            arrEmployee[i]=new employee();
            System.out.print("请输入第"+ii+"个员工的姓名:");
            String name= inp.next();
            System.out.print("请输入第"+ii+"个员工的年龄:");
            int age= inp.nextInt();
            System.out.print("请输入第"+ii+"个员工的职位:");
            String pos= inp.next();
            System.out.print("请输入第"+ii+"个员工的工资:");
            int sal= inp.nextInt();
            arrEmployee[i].setSalary(sal);
            arrEmployee[i].setAge(age);
            arrEmployee[i].setName(name);
            arrEmployee[i].setPosition(pos);
        }
        System.out.println("姓名      年龄      职位     工资");
        for (int i = 0; i < 3; i++) {
            arrEmployee[i].show();
        }
    }
}
