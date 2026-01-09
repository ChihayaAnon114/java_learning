package d9;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/*
a)创建一个Map对象，使用HashMap类进行实例化，以键-值对为“名字-电话”的形式向该map中添加通讯录信息，
采取循环的方式添加，循环一次，用户从键盘输入一对名字和电话，然后添加到map中，提示用户是否继续，输入Y则继续输入并添加，否则退出循环。
b)将通讯录中的信息按照名字升序显示出来
c)接受用户从键盘输入一个名字，查找在该通讯录中是否存在这个人，
如果存在则显示出这个人的电话，如果不存在， 则显示此人不存在
 */
public class phone_Map {
    public static void main(String[] args) {
        HashMap<String,String> Map_phone=new HashMap<>();
        Scanner input=new Scanner(System.in);
        String name;String num;
        //Map_phone.put(键，值)
        do{
            System.out.print("请输入姓名：");
            name= input.next();
            System.out.print("请输入电话号码：");
            num= input.next();
            Map_phone.put(name,num);
            System.out.println("是否继续输入？y/n");
        }while (input.next().equals("y"));
        Set<String> keys = Map_phone.keySet();
        for (String key:keys){
            String id_i=Map_phone.get(key);
            System.out.println(key+": "+id_i);
        }
//        Set<Integer>setInteger=phone_Map.k
    }
}
