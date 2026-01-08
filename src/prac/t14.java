package prac;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class t14 {
    /*
    输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
    使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
    并保证奇数和奇数，偶数和偶数之间的相对位置不变,
    每次只和前面一个数交换位置。或者利用辅助数组
     */
    public static void main(String[] args) {
        List<Integer>nums=new ArrayList<>(10);
        Scanner input=new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            nums.add(input.nextInt());
        }
        int temp=0;
        List num1=new ArrayList<>();
        List num2=new ArrayList<>();
        
    }
}
