package prac;

public class t16 {
    public ListNode ReverseList(ListNode head){
        ListNode res=null;
        ListNode node=head;
        while (head!=null){
            ListNode p = head.next;
            head.next = res;
            res = head;
            head = p;
        }
        return res;
    }
}
