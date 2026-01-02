package prac;
public class t3 {
    /*
    在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完
    成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     */
    public static void main(String[] args) {
        //……暂时省略
    }
    public static boolean find(int [][]mtrx,int trg){
        int col=mtrx[0].length;
        for (int i = 0; i <mtrx.length ; i++) {
            if (mtrx[i][col-1]<trg)
                continue;
            for (int j = 0; j <col; j++) {
                if (mtrx[i][j]==trg)
                    return true;
            }
        }
        return false;
    }
}
