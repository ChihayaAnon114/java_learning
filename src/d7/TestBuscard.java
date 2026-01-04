package d7;
import java.util.Scanner;
import java.util.Random;
/*
6、创建类TestBusCard，包含main()，实现如下功能：创建BusCard公交卡对象 buscard，
显示出该卡初始信息，显示效果为“您已申请一张***公司的乘车卡，卡号是****，押金***元，卡内余额为**元”，
再调用desposit()实现给公交卡充值的功能，充值的钱数通过控制台输入获取，如果充值失败，则给出相应的提示，
如果充值成功，则通过10次的循环，实现刷卡乘车的功能，每次循环，产生1-5的随机数，
代表需要刷卡的钱数，并调用consume()实现刷卡功能，每次刷卡都提示出刷卡是否成功，并显示本次刷卡后的卡内余额。
 */
public class TestBuscard {
    public static void main(String[] args) {
        BusCard busc=new BusCard();
        System.out.println("您已申请一张"+busc.getCompany()+"的乘车卡，卡号是"+busc.getCardID()+"，押金"+busc.getMortgage()+"元，卡内余额为"+busc.getMoney()+"元");
        Scanner in=new Scanner(System.in);
        int money;
        System.out.print("充值金额：");
        money= in.nextInt();
        if(busc.deposit(money)){
            System.out.println("充值完成");
        }
        else System.out.println("充值失败");
        Random random=new Random();
        int r; float m=0;
        for (int i = 0; i < 40; i++) {
            r= random.nextInt(5)+1;
            if (busc.consume(r)){
                System.out.print("刷卡成功，扣费"+r+"元");
                m= busc.getMoney();
                System.out.printf("余额为：%.2f\n",m);
            }
            else {
                System.out.println("余额不足");
                break;
            }
        }
    }

}
