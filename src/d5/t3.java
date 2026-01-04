package d5;
import java.util.Scanner;
public class t3 {
    /*
    求奇数和偶数的和
    a)main方法：接受用户从键盘输入一个数，判断该数是奇数还是偶数，如果是奇数，则调用自定义方法evenAdd()，
    求1—n之间的奇数的倒数和，并输出；如果是偶数，则调用自定义方法oddAdd()，求2—n之间的偶数倒数和，并输出。
    b)evenAdd方法：有一个int参数，用来接受main方法传递过来的值，使用循环求出从1到该数之间的奇数倒数和，并将计算结果进行返回。
    c)oddAdd方法：有一个int参数，用来接受main方法传递过来的值，使用循环求出从2到该数之间的偶数倒数和，并将计算结果进行返回。
     */
    public static void main(String[] args) {
        System.out.print("input:");
        Scanner in=new Scanner(System.in);
        int input=in.nextInt();
        if (input%2==0){
            float odd=oddadd(input);
            System.out.println(odd);
        }
        else
        {
            float even=evenadd(input);
            System.out.println(even);
        }
    }

    private static float evenadd(int A) {
        float res=0;
        float a=(float) A;
        for(float i=1;i<=a;i+=2)
        {
            res+=1/i;
//            System.out.print(res+" ");
        }
        return res;
    }

    private static float oddadd(int A) {
        float res=0;
        float a=(float) A;
        for(float i=2;i<=a;i+=2)
        {
            res+=1/i;
//            System.out.print(res+" ");
        }
        return res;
    }
}
