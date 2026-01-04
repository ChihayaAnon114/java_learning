package d6;
import java.util.Scanner;
/*
1）创建类Mobile（手机类），包含如下成员：
私有的属性：手机名(mobileName)、屏幕尺寸(mobileSize)、手机价格(mobilePrice)
公有的方法：
默认构造方法：空方法
带3个参数的构造方法：根据参数的值为每个属性赋值
2）创建类Customer（顾客类），包含如下成员：
私有的属性：顾客姓名(customerName)、顾客性别(customerSex)
公有的方法：
默认构造方法：为顾客姓名赋初值为“新顾客”加上3位随机数
（例如，新顾客520），为顾客性别赋值为“男”
自定义方法：public void buy(Mobile m);
实现顾客购买手机的功能。参数为Mobile类的对象，代表一个手机对象，
对该手机的尺寸和价格进行判断，当手机屏幕为5.5寸且价格不超过2000元时，进行购买1台，否则不够买。

 */
public class t3 {
    /*
    3）创建类TestCustomer，包含main()。先创建一个Customer对象，
调用默认构造方法实例化为初始顾客信息，再询问用户是否修改初始信息，根据用户的回答来操作修改或者不修改。
再创建一个Mobile对象，调用带参数构造方法，直接传递一台手机的信息，最后调用buy()，
实现顾客购买手机的功能。
     */
    public static void main(String[] args) {
        Customer c=new Customer();
        System.out.println("是否修改信息？y/n");
        Scanner inp=new Scanner(System.in);
        if(inp.next().equals("y"))
        {
            System.out.println("name:");
            c.setName(inp.next());
            System.out.println("gender:");
            c.setGender(inp.next());
        }
        Mobile m=new Mobile("极霸矛",7,1145);
        if(c.buy(m))
        {
            System.out.println("已购买");
        }
    }
}
