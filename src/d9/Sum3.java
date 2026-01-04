package d9;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Sum3 {
//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？请找出所有和为 0 且 不重复 的三元组。
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        ArrayList<Integer> lst=new ArrayList<>();
        int trg=0;
        System.out.println("trg=");
        trg= input.nextInt();
        String y;
        while(true){
            y= input.next();
            if (y.matches("-?\\d+")){
                lst.add(Integer.valueOf(y));
            }
            else break;
        }
        for (int j = 0; j < lst.size()-2; j++) {
            for (int i = lst.size()-1; i >j ; i--) {
                for (int k = lst.size()-1; k >i ; k--) {
                    if(lst.get(i)+ lst.get(j)+ lst.get(k)==trg&& !Objects.equals(lst.get(i), lst.get(j))
                    &&!Objects.equals(lst.get(k), lst.get(j))&&!Objects.equals(lst.get(i), lst.get(k)))
                    {
                        System.out.printf("%d,%d,%d\n",lst.get(i), lst.get(j),lst.get(k));
                    }
                }
            }
        }
    }
}
