package t9;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import t8.*;
public class collection_d {
    public static void main(String[] args) {
        Collection c1 = null;
        c1 = new ArrayList();
        c1.add(100);//ArrayList是数组类型，可以随机访问，增删需要重建数组。
        c1.add(114);
        c1.add(514);
        c1.add(3);
        c1.remove(3);
        System.out.println(c1);
        System.out.println(c1.size());
        Collection c2 = new ArrayList();
        System.out.println(c2);
        c2.removeAll(c2);
        List<Integer> l1 = new ArrayList<>();//集合类应当使用包装器类（而不应当使用基本类型），应当使用Object类下属的直接、间接子类
        l1.add(4);
        l1.add(0, 2);
        l1.remove((Integer) 4);
        //collection或者list 可以存在重复元素
        //collection无序，无索引，list有索引。
        ArrayList<Student> l2 = new ArrayList<>();
        l2.add(new Student("12", "221", 22));
        l2.add(new Student("21", "112", 21));
        System.out.println(l2.get(1).toString());
    }
    LinkedList l3=new LinkedList<>();//linkedlist是单向链表，不能从中间插入和查看，添加、删除效率比较高
}
