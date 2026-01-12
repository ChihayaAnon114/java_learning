package d8;

public abstract class chouxianglei {
    //抽象类
    protected int age;
    public String name;

    public abstract void eat() ;
    //抽象类的抽象方法：子类必须存在实现
    //抽象方法只能存在普通类
    public chouxianglei(){
    }
    //抽象类可以存在普通方法

    /*
    构造实现顺序：先父再子
    多态性：
    1，继承，2，子类需要继承与重写父类的方法，3，父类引用指向子类的对象：向上转型，调用的时候优先使用this指针而不是父类指针
    强制类型转换：大类型（父类）可以默认转换为小类型（子类），也可以默认调用其父类的方法
     */
    public static void main(String[] args) {
        jiekou_diaoyong j1=new jiekou_diaoyong();
        j1.send();//接口实现方法
    }
}
