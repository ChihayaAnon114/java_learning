package d6;
import java.util.Random;

public class Customer {
    /*
    创建类Customer（顾客类），包含如下成员：
    私有的属性：顾客姓名(customerName)、顾客性别(customerSex)
    公有的方法：
    默认构造方法：为顾客姓名赋初值为“新顾客”加上3位随机数
    （例如，新顾客520），为顾客性别赋值为“男”
    自定义方法：public void buy(Mobile m);
    实现顾客购买手机的功能。参数为Mobile类的对象，代表一个手机对象，
    对该手机的尺寸和价格进行判断，当手机屏幕为5.5寸且价格不超过2000元时，进行购买1台，否则不够买。
     */
    private String name;
    private String gender;
    Customer(){
        Random rand = new Random();
        this.name=String.valueOf( 100+rand.nextInt(900));
        this.gender="男";
    }
    public boolean buy(Mobile m){
        return m.getSize() >= 5.5 && m.getPrice() <= 2000;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
