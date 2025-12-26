package d6;
//1）创建类Book（书类），包含如下成员：
//私有的属性：书名(name)、页数(page)、价格(price)
//公有的方法：
//私有属性对应的get、set方法
//默认构造方法：给3个属性赋初始值（初始值分别为：”unknown”, 1, 0.0）
//带3个参数的构造方法：通过3个参数的值为对应的属性赋值
public class book_for_t1 {
    public void print_book(){
        System.out.printf("name: "+this.name+" page: "+this.page+" price: %.2f\n",this.price);
    }

    public float get_bookprice() {
        return this.price;
    }

    public int get_bookpage(int p1) {
        return this.page;
    }

    public String get_bookname() {
        return this.name;
    }

    private String name;
    private int page;
    private float price;
    book_for_t1(){
        name="unknown";page=1;price=0;
    }
    book_for_t1(String name,int page,float price)
    {
        this();
        this.name=name;this.page=page;this.price=price;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
