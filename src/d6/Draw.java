package d6;
/*
创建子包draw，实现如下功能
1）创建类Draw（代表图形），包含：
属性：private double drawRound；（代表图形的周长）
构造方法：给属性赋值为0；
只写对应的get方法，不写set方法
方法：void round（double r） 计算圆形的周长，参数表示圆的半径
方法：void round（int length，int width） 计算长方形的周长，参数表示长方形的长与宽
方法：void round（int length）计算正方形的周长，参数表示正方形的边长
方法：void round（int a，int b，int c）计算三角形的周长，参数表示三角形的三条边。
 */
public class Draw {
    private double drawRound;
    public void round(int l)
    {
        this.drawRound=4*l;
    }
    public void round(int a,int b)
    {
        this.drawRound=2*(a+b);
    }
    public void round(double r)
    {
        this.drawRound=r*r*3.1415;
    }
    public void round(int a,int b,int c){
        this.drawRound=a+b+c;
    }

    public double getDrawRound() {
        return drawRound;
    }
}
