package t9;
import java.util.ArrayList;
import java.util.Scanner;

public class twoSum {
    //给定一个已按照 升序排列 的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        ArrayList<Integer>lst=new ArrayList<>();
        int trg=0;
        System.out.println("trg=");
        trg= input.nextInt();
        int lstlen =0;
        String y;
        while(true){
            y= input.next();
            if (y.matches("-?\\d+")){
                lst.add(Integer.valueOf(y));
                lstlen++;
            }
            else break;
        }
        for (int j = 0; j < lst.size()-2; j++) {
            for (int i = lst.size()-1; i >j ; i--) {
                if (lst.get(i)+lst.get(j)==trg)
                    System.out.printf("%d, %d\n",lst.get(i),lst.get(j));
            }
        }
    }
}
