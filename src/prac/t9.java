package prac;

import java.util.ArrayList;
import java.util.List;

/*
现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
 */
public class t9 {
    public static Integer n=6;
    public static void main(String[] args) {
        Integer res=0;
        List<Integer> result= new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i<=1)
                res=1;
            else {
                res=result.get(i-1)+result.get(i-2);
            }
            result.add(res);
        }
        System.out.println(result);
    }
}
