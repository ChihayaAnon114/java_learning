package prac;

import java.util.ArrayList;
import java.util.List;

import static prac.ListNode.fromArray;

public class t17 {
    //输入两个单调递增的链表，输出两个链表合成后的链表
    public static ListNode merge(ListNode lst1,ListNode lst2){
        ListNode res=null;
        if (lst1==null)return lst2;
        else if (lst2==null)return lst1;

        else {

            if (lst2.val>lst1.val)
                res.next=merge(lst1,lst2.next);
            else res.next=merge(lst1,lst2);
        }
        return res;
    }

//    public static void main(String[] args) {
//        ListNode l1=new ListNode();
//        List l=[1,3,4,5,7]
//        l1=fromArray()
//    }
}
