package t8;
/*
    4、创建类Student(学生类，学生的年龄在7-18岁之间)，实现IPerson接口，包含如下成员：
    1）private属性：stuName,stuAge,stuSex
    2）方法：实现接口中的所有抽象方法，这些方法的功能用于给该类的私有成员变量进行取值和赋值
 */
public class Student extends User
        implements IPearson {
    private String stuName;
    private String stuSex;
    private int stuAge;
    public void setName(String perName){
        stuName =perName;
    }
    public void setAge(int perAge){
        stuAge =perAge;
    }
    public void setSex(String perSex){
        stuSex=perSex;
    }
    public String getName(){
        return stuName;
    }
    public int getAge(){
        return stuAge;
    }
    public String getSex(){
        return stuSex;
    }
    public Student(String Name, String Sex, int Age){
        super();
        setAge(Age);setName(Name);setSex(Sex);
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuName='" + stuName + '\'' +
                ", stuSex='" + stuSex + '\'' +
                ", stuAge=" + stuAge +
                '}';
    }
}
