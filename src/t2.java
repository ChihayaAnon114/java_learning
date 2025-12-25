import java.util.*;
public class t2
{/*
数组元素的获取
1）声明一个长度为10的整型数组
2）通过循环为数组赋值为10个1-100之间的随机整数
3）输出数组中的所有偶数。
*/

    public static void main(String[] args) {
        int []arr=new int[10];
        Random r=new Random();
        for (int i=0;i<10;i++)
        {
            arr[i]=r.nextInt(100);
        }
        for (int i = 0; i < 10; i++) {
            if (arr[i]%2==0)
                System.out.print(arr[i]+" ");
        }
    }
}
