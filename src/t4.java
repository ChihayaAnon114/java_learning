import java.util.Scanner;
public class t4 {
    /*
    数组的应用
    1)声明一个double类型的数组，用来存储员工的工资
    2)提示用户输入有多少个员工
    3)根据员工的个数，给数组分配长度
    4)接受用户从键盘输入每个员工的工资
    5)显示出所有员工的工资
    6)统计出所有员工的平均工资并输出
    求出最高工资和最低工资，并显示分别是哪个员工的工资
     */
    public static void main(String[] args) {
        int i=0;int total=0;
        System.out.println("请输入员工数量：");
        Scanner input=new Scanner(System.in);
        i=input.nextInt();
        double[]arr=new double[i];
        for (int j = 0; j < i; j++) {
            System.out.print("请输入当前员工工资：");
            arr[j]= input.nextFloat();
            total+=arr[j];
        }
        System.out.print("所有员工工资：");
        for (int j = 0; j < i; j++)
            System.out.printf("%.2f ",arr[j]);

        double max=0;
        for (int j = 0; j < i; j++) {
            if(arr[j]>max)
                max=arr[j];
        }
        System.out.printf("\n员工最高工资：%.2f\n",max);
        double min=114514;
        for (int j = 0; j < i; j++) {
            if(arr[j]<min)
                min=arr[j];
        }
        System.out.printf("员工最低工资：%.2f \n",min);
        double avg=total/i;
        System.out.printf("员工平均工资：%.2f",avg);
        }
    }
