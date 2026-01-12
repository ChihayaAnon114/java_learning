package d5;
import java.util.Scanner;
public class t4 {
    /*
    向数组中添加非0数字，循环接受用户输入非0数字，并添加到数组中，重复元素不可以添加，具体要求如下：
    1）创建自定义函数int find(int arr[],int num)：用于查找num在arr数组中是否存在，如果存在，返回该数在数组中的位置，若不存在，则返回-1
    2）创建自定义函数int insert(int arr,int num): 用于向arr数组中添加num元素，在arr数组中查找第一个为0的元素，将num的值添加到该位置，并返回添加成功之后的位置，如果找不到为0的数字，则返回-1，代表数组已满，不可以再插入。
    3）在main方法中创建长度为10的数组，并全部初始化为0。
    4）main方法中接受用户从键盘输入一个数字
    i.如果是0，则提示错误并重新输入；
    ii.如果不是0，则调用自定义方法find(),查找该数在数组中是否存在；
    1.如果存在，则提示该数已存在，不可以向数组中插入，然后询问用户是否继续输入下一个数
    2.如果不存在，则调用自定义方法insert()，向数组中添加此数，添加成功询问用户是否继续输入下一个元素，直到用户不想再输入或者数组已满，则停止循环
    5）main方法中输出添加结束之后的数组
     */
    public static void main(String[] args) {
        int[]arr=new int[10];
        Scanner input=new Scanner(System.in);
        while (!isFull(arr))
        {
            System.out.print("请输入数字,输入负数则退出输入：");
            int in=input.nextInt();
            if(find(in,arr)!=-1)
            {
                System.out.println("已存在");
            } else if (in==0) {
                System.out.println("不允许输入0");
            } else
            {
                if(isFull(arr)||in<0)
                {
                    System.out.println("已停止输入");
                    break;
                }
                insert_array(in,arr);

            }
        }
        for (int j : arr) {
            System.out.print(j + " ");
        }

    }
    private static void insert_array(int in,int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==0)
            {
                arr[i]=in;
                break;
            }
        }
    }

    private static boolean isFull(int[] arr) {
        boolean flag=true;
        for (int j : arr) {
            if (j == 0) {
                flag = false;
                break;
            }
        }
        return  flag;
    }

    private static int find(int in,int[]arr) {
        for (int i = 0; i < arr.length; i++) {
            if(in==arr[i]) {
                return i;
            }
        }
        return -1;
    }
}
