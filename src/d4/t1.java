package d4;

import java.util.Scanner;
public class t1 {
    /*
    数组的输入和输出
    1）声明一个长度为5的整型数组
    2）通过控制台输入为每个数组元素赋值
    3）显示出所有元素的值
     */
    public static void main(String[] args) {
        int []arr=new int[5];
        Scanner input=new Scanner(System.in);
        for(int i=0;i<5;i++)
        {
            arr[i]= input.nextInt();
        }
        for(int i=0;i<5;i++)
            System.out.println(arr[i]);
        demo1.a1(2);
    }
}
