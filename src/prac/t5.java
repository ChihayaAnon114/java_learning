package prac;
import java.util.ArrayList;
import java.util.List;
public class t5 {
    //输入一个链表，从尾到头打印链表每个节点的值。
    public static void main(String[] args) {
        //......
        ArrayList lst=new ArrayList<Integer>();
        for (int i = 100; i >0; i--) {
            lst.add(i);
        }
        System.out.println(lst);
        System.out.println(reverse_l(lst));
    }

    public static ArrayList reverse_l(ArrayList list){
        ArrayList temp_lst =new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {
            temp_lst.add(list.get(list.size()-i-1));
        }
        return temp_lst;
    }
}
