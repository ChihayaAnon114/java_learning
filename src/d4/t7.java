package d4;

import java.util.Random;
public class t7 {
    /*
    实现双色球的机选功能
    1）双色球的构成：6个红号+1个蓝号，红号的范围是1-33，蓝号的范围是1-16。
    2）声明一个长度为6的整型数组，存储6个不同的1-33之间的随机数；声明一个变量，存储1-16之间的随机数；输出机选的号码。     */
    public static void main(String[] args) {
        int[]red=new int[6];
        Random r=new Random();
        for (int i = 0; i < 6; i++) {
            red[i]= r.nextInt(33)+1;
            boolean flag;
            do{
                flag=false;
                for (int j = 0; j <i; j++) {
                    if(red[j]==red[i])
                    {flag=true;red[i]= r.nextInt(33)+1;}
                }
            }while (flag);
        }
        for (int i = 0; i < 6; i++) {
            System.out.print("red:"+red[i]+" \n");
        }
        int blue=r.nextInt(16)+1;
        System.out.println("blue:"+blue);
    }
}