package d6;


public class Student {
    /*
    2．创建类Student，包含成员如下
    a)private属性：name、sex、birthday（该属性要求为Date类型）
    b)默认构造方法，为属性初始化为：“新同学”，性别为“未知”，生日为“1990-4-10”
    c)带有5个参数的构造方法，根据参数为属性赋值
    d)public void showMessage()，输出学生的所有信息。
     */
    private String name;
    private String gender;
    private M_date birthday;
    public Student(){
        M_date default_birthday=new M_date(1990,4,10);
        this.name="新同学";
        this.gender="未知";
        this.birthday=default_birthday;
    }
    public Student(String n,String g,int y,int m,int d){
        this.name=n;
        this.gender=g;
        this.birthday=new M_date(y,m,d);
    }
    public void show(){
        System.out.println("student message: name:"+this.name+" gender:"+this.gender+" birthday:"+birthday.showDate());
    }
}
