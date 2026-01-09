package d6;
/*
1）创建类Mobile（手机类），包含如下成员：
私有的属性：手机名(mobileName)、屏幕尺寸(mobileSize)、手机价格(mobilePrice)
公有的方法：
默认构造方法：空方法
带3个参数的构造方法：根据参数的值为每个属性赋值
 */
public class Mobile {
    private String name;
    private float size;
    private int price;
    Mobile(){}
    Mobile(String name,float size,int price){
        this.name=name;this.size=size;this.price=price;
    }

    public float getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
