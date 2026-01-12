package d5;

import java.util.Scanner;
public class t1 {
    /*
    程序1：计算三角形面积
    1）创建类Draw，包含一个自定义方法calculateArea()，并带有3个整型参数。参数代表三角形的三条边，计算三角形的面积，并返回。
    2）创建类TestDraw，通过控制台输入3个整数，代表三角形的三条边，判断能否构成三角形，
    如果不能构成，则给出提示；如果可以构成三角形，则调用calculateArea()，计算该三角形的面积。
     */
    public static Boolean TestDraw(int a,int b,int c)
    {
        if(a>=b+c||b>=a+c||c>=a+b)
            return false;
        return true;
    }
    public static float CalculateArea(int A,int B,int C)
    {
        float a=(float)A;float b=(float)B; float c=(float) C;
        float s=(a+b+c)/2;
        float S= (float) Math.sqrt(s*(s-a)*(s-b)*(s-c));
        return S;
    }

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("请输入三条边长：");

        while (true)
        {
            int a= input.nextInt();int b= input.nextInt();int c= input.nextInt();
            if(TestDraw(a,b,c))
            {
                System.out.println("三角形面积为");
                System.out.println(CalculateArea(a,b,c));
                break;
            }
            else
                System.out.println("请重新输入");
        }
    }
}
