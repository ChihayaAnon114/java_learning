package d6;
import java.util.Scanner;
/*

2）创建类TestBook：包含main()，
创建两个Book类对象，分别调用默认构造方法和带参数的构造方法为两个对象进行实例化，
调用带参数的构造方法实例化对象时，参数的值随意指定，分别显示出这两本书的信息。
再通过控制台输入重新为这两本书的属性赋值，再显示出两本书的信息。
 */
public class t1 {
    public static void main(String[] args) {
        book_for_t1 book1=new book_for_t1("book1",114, 51.4F);
        book_for_t1 book2=new book_for_t1("book2",1919,810);
        Scanner in=new Scanner(System.in);

        String name1=in.next();
        int p1= in.nextInt();
        float pr1= in.nextFloat();
        book1.setName(name1);
        book1.setPage(p1);
        book1.setPrice(pr1);
        book1.print_book();
        book2.print_book();
    }
}
