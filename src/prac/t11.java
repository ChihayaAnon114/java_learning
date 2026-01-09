package prac;

public class t11 {
    /*
    给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。不得使用库函数
     */
    public static void main(String[] args) {

    }
    public static double multi(double base,int ex)
    {
        double res=1;
        if (base==0){
            return 0;
        }
        else {
            for (int i = 0; i <ex ; i++) {
                res*=base;
            }
            return res;
        }
    }
}
