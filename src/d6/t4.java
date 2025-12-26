package d6;
import java.util.Scanner;
/*
创建子包draw，实现如下功能

2）创建类TestDraw，主方法中，接受用户输入每种图形求周长所需要的数据，
并调用相应的round方法求出周长并显示出来，注意描述清楚是哪一种图形
 */
public class t4 {
    public static void main(String[] args) {
        Scanner inp=new Scanner(System.in);
        Draw square=new Draw();
        System.out.println("square:");
        int l=inp.nextInt();
        square.round(l);
        Draw circle=new Draw();
        System.out.println(square.getDrawRound());
        System.out.println("circle:");
        double r=inp.nextDouble();
        circle.round(r);
        System.out.println(circle.getDrawRound());
        Draw rect=new Draw();
        System.out.println("rectangle:");
        int a=inp.nextInt();int b= inp.nextInt();
        rect.round(a,b);
        System.out.println(rect.getDrawRound());
        Draw tri=new Draw();
        a= inp.nextInt();b= inp.nextInt();int c= inp.nextInt();
        tri.round(a,b,c);
        System.out.println(tri.getDrawRound());

        /*
        1）创建类Draw（代表图形），包含：
        属性：private double drawRound；（代表图形的周长）
        构造方法：给属性赋值为0；
        只写对应的get方法，不写set方法
        方法：void round（double r） 计算圆形的周长，参数表示圆的半径
        方法：void round（int length，int width） 计算长方形的周长，参数表示长方形的长与宽
        方法：void round（int length）计算正方形的周长，参数表示正方形的边长
        方法：void round（int a，int b，int c）计算三角形的周长，参数表示三角形的三条边。
         */
    }
}
