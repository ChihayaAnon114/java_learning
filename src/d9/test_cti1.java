package d9;
import java.util.*;
/*
    2．创建TestCity类，包含main()方法
    a)创建List集合，用来存储多个城市的信息，城市的信息从控制台输入，不要输入重复的ID和名字。
    每获取一个城市的信息，都询问用户是否继续输入下一个城市信息，如果用户按“Y”，则继续获取用户的输入，否则结束输入。
    b)显示出来List集合中的所有的城市信息
    c)将List集合中的所有城市信息存储到Map中
    d)通过控制台输入一个城市的ID，判断该ID是否在Map中存在，如果存在，则显示出该ID对应的城市名字（通过对Map的操作实现）
 */
public class test_cti1 {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        List<City> cities=new ArrayList<>();
        do {
            City c=new City();
            inp_id(cities,c);
            inp_name(cities,c);
            cities.add(c);
            System.out.println("continue?y/n");
        }while(input.next().equals("y"));
        Map<Integer, String> map=new HashMap<Integer,String>();
        for (int j = 0; j <cities.size() ; j++) {
            City c = cities.get(j);
            map.put(c.getCityID(),c.getCityName());
            System.out.println(c.toString());
        }
    }

    private static void inp_name(List<City> cities, City c) {
        boolean flag=false;
        Scanner input=new Scanner(System.in);
        String cname;
        System.out.print("input city name: ");

        do {
            flag=false;
            cname = input.next();
            for (int i = 0; i <cities.size() ; i++) {
                City c_i=cities.get(i);
                if(Objects.equals(c_i.getCityName(), cname)){
                    flag=true;
                    break;
                }
            }
            if (flag){
                System.out.print("name existed, re-enter city name: ");
            }
        }while (flag);
        c.setCityName(cname);
    }


    private static void inp_id(List<City> cities, City c) {
        boolean flag=false;
        Scanner input=new Scanner(System.in);
        int cid;
        System.out.print("input city ID: ");

        do {
            flag=false;
            cid = input.nextInt();
            for (int i = 0; i <cities.size(); i++) {
                City c_i=cities.get(i);
                if(c_i.getCityID()==cid){
                    flag=true;
                    break;
                }
            }
            if (flag){
                System.out.print("id existed, re-enter city id: ");
            }
        }while (flag);
        c.setCityID(cid);
    }
}
