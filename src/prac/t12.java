package prac;

import java.util.Scanner;

public class t12 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        // 1) 初始化 n 个 '0'
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; i++) res.append('0');

        // 2) 计算循环次数：10^n（注意不是 ^ 运算）
        int limit = (int) Math.pow(10, n);

        // 3) 循环：打印当前值 -> 加一
        for (int i = 0; i < limit; i++) {
            System.out.print(revert_num(res.toString())+" ");
            increment(res); // 生成下一个 n 位数
        }
    }

    private static void increment(StringBuilder sb) {
        int i = sb.length() - 1;
        while (i >= 0) {
            char c = sb.charAt(i);
            if (c < '9') {
                sb.setCharAt(i, (char) (c + 1));
                return;
            } else {
                sb.setCharAt(i, '0');
                i--;
            }
        }
    }

    public static String revert_num(String num) {
        if (num == null || num.length() == 0) return "";
        int k = 0;
        while (k < num.length() - 1 && num.charAt(k) == '0') {
            k++;
        }
        return num.substring(k);
    }
}
