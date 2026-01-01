package t9;

/*
    2．创建TestCity类，包含main()方法
    a)创建List集合，用来存储多个城市的信息，城市的信息从控制台输入，不要输入重复的ID和名字。
    每获取一个城市的信息，都询问用户是否继续输入下一个城市信息，如果用户按“Y”，则继续获取用户的输入，否则结束输入。
    b)显示出来List集合中的所有的城市信息
    c)将List集合中的所有城市信息存储到Map中
    d)通过控制台输入一个城市的ID，判断该ID是否在Map中存在，如果存在，则显示出该ID对应的城市名字（通过对Map的操作实现）
 */
public class City {
    /*
    1．创建一个类City，包含如下成员：
    a)private int cityID; 城市的ID
    b)private String cityName;  城市的名字
    c)默认构造方法：只定义，无需写代码
    d)添加get/set方法
     */
    private int cityID;
    private String cityName;
    City(){}

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityID=" + cityID +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
