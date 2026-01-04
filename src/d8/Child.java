package d8;

public class Child extends User
        implements IPearson{
    /*
    3、创建类Child（儿童类，儿童的年龄在3-6岁之间），实现IPerson接口，包含如下成员：
    1）private属性：chdName, chdAge, chdSex
    2）方法：实现接口中的所有抽象方法，这些方法的功能用于给该类的私有成员变量进行取值和赋值
     */
    private String chdName;
    private String chdSex;
    private int chdAge;
    public void setName(String perName){
        chdName=perName;
    }
    public void setAge(int perAge){
        chdAge=perAge;
    }
    public void setSex(String perSex){
        chdSex=perSex;
    }
    public String getName(){
        return chdName;
    }
    public int getAge(){
        return chdAge;
    }
    public String getSex(){
        return chdSex;
    }

    public Child(String chdName, String chdSex, int chdAge) {
        super();
        this.chdName = chdName;
        this.chdSex = chdSex;
        this.chdAge = chdAge;
    }
}
