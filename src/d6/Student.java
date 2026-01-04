package d6;
public class Student {
        /*
        2．创建类Student，包含成员如下
        a)private属性：name、sex、birthday（该属性要求为Date类型）
        b)默认构造方法，为属性初始化为：“新同学”，性别为“未知”，生日为“1990-4-10”
        c)带有5个参数的构造方法，根据参数为属性赋值
        d)public void showMessage()，输出学生的所有信息。
         */
        public String name;
        private String gender;
        private My_date birthday;
        My_date default_birthday=new My_date(1990,4,10);

        public Student(String n, String g, int y, int m, int d) {
                name = n;
                gender=g;
                birthday= new My_date(y,m,d);
        }

        public Student() {
                name = "未知";
                gender="未知";
                birthday= new My_date(2025,1,1);
        }

        public void show(){
    System.out.println("student message: name:"+this.name+" gender:"+this.gender+" birthday:"+birthday.showDate());
        }
}
