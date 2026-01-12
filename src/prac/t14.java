package prac;
import java.util.ArrayList;
import java.util.Scanner;
public class t14 {
    /*
    输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
    使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
    并保证奇数和奇数，偶数和偶数之间的相对位置不变,
    每次只和前面一个数交换位置。或者利用辅助数组
     */
    public static ArrayList<Integer> sort(ArrayList list){
        ArrayList<Integer>lst1=new ArrayList<>();
        ArrayList<Integer>lst2=new ArrayList<>();
        for (int i = 0; i < list.size() ; i++) {
            int num= (int) list.get(i);
            if (num%2==1)
                lst1.add(num);
            else
                lst2.add(num);
        }
        lst1.addAll(lst2);
        return lst1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> lst=new ArrayList<>();
        Scanner input=new Scanner(System.in);
        int num=0;
        while (true){
            num= input.nextInt();
            if (num<=0)
                break;
            else {
                lst.add(num);
            }
        }
        System.out.println(sort(lst));
    }
}
