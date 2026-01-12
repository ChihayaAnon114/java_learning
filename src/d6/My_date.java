package d6;

public class My_date {
    /*
    创建类Date，用来描述日期数据，包含成员如下
    a)private属性year、month、day，分别用来表示日期的年、月、日
    b)默认构造方法，给属性赋值为当前日期（根据今天的日期赋值即可）
    c)带参数的构造方法，根据参数给属性赋值
    d)public String showDate()：以字符串的方式返回由3个属性值组成的一个日期数据，年，月，日使用“-”间隔
     */
    private int year;
    private int month;
    private int day;
    My_date(){
        year=2025;month=12;day=27;
    }

    public My_date(int i, int i1, int i2) {
        this.year=i;
        this.month=i1;
        this.day=i2;
    }

    public String showDate()
    {
        return year+"-"+month+"-"+day;
    }
}
