package d5;
import java.util.Random;
import java.util.Scanner;
public class t2 {
    /*
    1）玩家：电脑和用户
    2）出拳规则：1 - 石头 2 - 剪刀 3 - 布
    3）创建类Game，包含如下3个自定义方法
    a) user()：完成接收控制台输入玩家的出拳，如果出拳无效，要求重新出拳，如果出拳有效，则输出用户的出拳是什么，并返回用户的出拳；
    b)computer()：完成电脑的随机出拳，随机出1-3之间的数字，代表电脑出拳，输出电脑出拳是什么，并返回电脑的出拳；
    c)compare()：带有两个参数，分别代表电脑和用户的出拳，判断出谁输谁赢，输出比较结果。
    main：分别调用3个方法，实现猜拳游戏的功能。
     */
    static Scanner in=new Scanner(System.in);
    public static int compare(int a,int b)
    {
        if(a==b)
            return 0;
        if((a==1&&b==2)||(a==2&&b==3)||(a==3&&b==1))
            return 1;
        else return 2;
    }
    public static int user()
    {
        System.out.print("1 - 石头 2 - 剪刀 3 - 布：");
        int u=in.nextInt();
        return u;
    }
    public static int com()
    {
        Random r=new Random();
        int ran=1+r.nextInt(3);
        System.out.println(ran);
        return ran;
    }

    public static void main(String[] args) {
        int u=user();
        int c=com();
        int res=compare(u,c);
        if(res==0)
            System.out.println("平");
        else if (res==1) {
            System.out.println("赢");
        }
        else System.out.println("输");
    }
}
