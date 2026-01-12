package prac;

public class t15 {
    public ListNode FindKthToTail(ListNode head,int k){
        if (head == null || k <= 0) {
            return null;
        }
        ListNode node1=head;
        ListNode node2=head;
        for (int i = 0; i <k ; i++) {
            if (node1.next!=null){
                node1=node1.next;
            }
            else return null;
        }
        while (node2.next!=null){
            node1=node1.next;
            node2=node2.next;
        }
        return node2;
    }
}
