import java.util.Scanner;
public class t6 {
    /*
    1）现有5名候选人要竞选班长，每个人的编号分别为1、2、3、4、5。 现有若干人为这5个候选人进行投票。
    2）循环接受每个人从键盘输入所投票的编号，若投票有效，则进行统计相应候选人的票数，若投票无效，则提示投票无效，
    并继续接受下一个投票，直到接受的投票为0号时，投票结束。
    3）显示出每位候选人的得票数
     */
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int[]select=new int[6];
        while (true)
        {
            int x= input.nextInt();
            if(x==0)
                break;
            else if (x>5||x<0) {
                System.out.println("投票无效");
            }
            else {
                select[x]++;
            }
        }
        System.out.println("候选人1："+select[1]+"|候选人2："+select[2]+"|候选人3："+select[3]+"|候选人4："+select[4]+"|候选人5："+select[5]);
    }
}
