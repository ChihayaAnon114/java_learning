package t8;
//    5、创建类Adult (成人类，成人的年龄在19岁以上)，实现IPerson接口，包含如下成员
//    1）private属性：adtName,adtAge,adtSex
//    2）方法：实现接口中的所有抽象方法，这些方法的功能用于给该类的私有成员变量进行取值和赋值
public class Adult {
    private String adName;
    private String adSex;

    private int adAge;
    public void setName(String perName){
        adName =perName;
    }
    public void setAge(int perAge){
        adAge =perAge;
    }
    public void setSex(String perSex){
        adSex=perSex;
    }
    public String getName(){
        return adName;
    }
    public int getAge(){
        return adAge;
    }
    public String getSex(){
        return adSex;
    }
}
