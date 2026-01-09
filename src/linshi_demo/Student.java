package linshi_demo;

public class Student {
    int score = 0;
    String name;
    //this: 用于调用当前实例，例如调用该对象内部的方法或者对象均可
    //静态成员：所有实例共享相同值
    //可以被每一个实例修改，
    //static final：常量，不允许被实例对象修改
    //final:不是共性，但是不允许修改；
    Student()
    {
        //用于调用当前类的实例，给成员赋予初始值。创建的时候自动调用
        //与类名相同，没有返回值，没有关键词
        //允许有多个构造方法，参数需要不同(重载)
        //如果存在有参构造函数，系统将不会自动构造无参数构造函数！！！
        //在方法内声明的变量是局部变量，在方法外无法直接使用

    }
    Student(int score){
        this.score=score;
    }

}
