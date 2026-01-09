package d12.DBver_2;

public class RecordLine {
    //这是一个完全通用的类。这个类的主要结构是：Integer序号 String主键, String列表格式的所有数据。
    //当序号等于主键的时候可以使用to string方法
    public int col_num=5;//列数
    public Integer num;//序号
    public String mainKey;//主键
    public String[] recordLine=new String[col_num];

}
