import java.util.Scanner;
import static java.lang.Float.parseFloat;
public class t5 {
    /*
    统计商场的总收入
    1）修改商场打折活动的题目（“02 分支结构程序设计”中的程序3），实现能够连续为客户结账的功能
    2）每次为一位顾客结账结束之后，提问是否继续为下一位顾客结账，当输入‘y’的时候则继续，否则结束。
    3）最后统计出所有顾客的消费金额
    1）修改之前做过的商场打折的题目，当为所有的顾客结账结束之后统计出今天本商场的收入总额是多少钱，即统计出所有顾客的支付金额的总和
    2）显示出今天的最高消费额和最低消费额分别为多少钱
     */
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        float total=0;
        int num=0;
        float[]journal=new float[1000];
        String flag;boolean bool;
        do {
            float bill=0;
            bool=true;
            System.out.print("请输入当前商品金额： ");
            bill+= input.nextFloat();
            do {
                System.out.print("请输入下一个商品金额（按n键结算）");
                flag= input.next();
                if(flag.equals("n"))
                    bool=false;
                else
                    bill+=parseFloat(flag);
            }
            while(bool);
            System.out.printf("总价为：%.2f 元\n",bill);
            System.out.println("是否继续结账？（按y继续，按其他按键退出系统）");
            journal[num]=bill;
            total+=bill;
            num++;
        }
        while(input.next().equals("y"));
        float max=0;float min=114514;
        for (int i = 0; i < 1000; i++) {
            if (journal[i]==0)
                break;
            if (journal[i]>max)
                max=journal[i];
        }
        for (int j = 0; j < 1000; j++) {
            if (journal[j]==0)
                break;
            if (journal[j]<min)
                min=journal[j];
        }
        System.out.printf("当日最大销售额为：%.2f\n",max);
        System.out.printf("当日最小销售额为：%.2f\n",min);
        System.out.printf("当日总销售额为：%.2f\n",total);
        System.out.println("系统已退出");
    }
}