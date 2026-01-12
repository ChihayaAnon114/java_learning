package prac;

import java.util.Arrays;

/**
 * 通用单链表节点 + 常用工具方法
 * 字段：int val，ListNode next
 * 底层实现：单向链式结构。每个节点保存一个整数值和对下一个节点的引用；最后一个节点 next == null。
 *
 *fromArray(int[] arr)：输入 int[]，输出 ListNode（链表头结点）
 *
 * toArray(ListNode head)：输入 ListNode，输出 int[]
 *
 * toString(ListNode head)：输入 ListNode，输出 String（形如 1 -> 2 -> 3）
 *
 * length(ListNode head)：输入 ListNode，输出 int
 *
 * getKth(ListNode head, int k)：输入 ListNode, int，输出 ListNode（第 k 个，1-based）
 *
 * append(ListNode head, int val)：输入 ListNode, int，输出 ListNode（新的头结点，便于链表为空时追加）
 *
 * reverse(ListNode head)：输入 ListNode，输出 ListNode（反转后的新头）
 *
 * equalsList(ListNode a, ListNode b)：输入两条链表头，输出 boolean
 */
public class ListNode {
    public int val;
    public ListNode next;

    /** 空构造：部分题会用到 */
    public ListNode() {}

    /** 单值构造 */
    public ListNode(int val) {
        this.val = val;
    }

    /** 值 + next 构造 */
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // =========================
    // 构建与转换
    // =========================

    /**
     * 从数组构建链表，返回头结点。
     * 输入：int[]
     * 输出：ListNode（head）
     */
    public static ListNode fromArray(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for (int x : arr) {
            tail.next = new ListNode(x);
            tail = tail.next;
        }
        return dummy.next;
    }

    /**
     * 将链表转为数组。
     * 输入：ListNode head
     * 输出：int[]
     */
    public static int[] toArray(ListNode head) {
        int n = length(head);
        int[] res = new int[n];
        int i = 0;
        ListNode cur = head;
        while (cur != null) {
            res[i++] = cur.val;
            cur = cur.next;
        }
        return res;
    }

    /**
     * 返回链表长度。
     * 输入：ListNode head
     * 输出：int
     */
    public static int length(ListNode head) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        return n;
    }

    /**
     * 追加一个值到链表末尾，返回（可能更新的）头结点。
     * 输入：ListNode head, int val
     * 输出：ListNode（new head）
     */
    public static ListNode append(ListNode head, int val) {
        ListNode node = new ListNode(val);
        if (head == null) return node;
        ListNode cur = head;
        while (cur.next != null) cur = cur.next;
        cur.next = node;
        return head;
    }

    /**
     * 获取第 k 个节点（1-based）。k<=0 或越界返回 null。
     * 输入：ListNode head, int k
     * 输出：ListNode
     */
    public static ListNode getKth(ListNode head, int k) {
        if (k <= 0) return null;
        ListNode cur = head;
        for (int i = 1; i < k && cur != null; i++) {
            cur = cur.next;
        }
        return cur;
    }

    // =========================
    // 常用算法辅助
    // =========================

    /**
     * 反转链表，返回新头结点。
     * 输入：ListNode head
     * 输出：ListNode
     */
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    /**
     * 判断两条链表值序列是否相等（不比较引用身份）。
     * 输入：ListNode a, ListNode b
     * 输出：boolean
     */
    public static boolean equalsList(ListNode a, ListNode b) {
        ListNode p = a, q = b;
        while (p != null && q != null) {
            if (p.val != q.val) return false;
            p = p.next;
            q = q.next;
        }
        return p == null && q == null;
    }

    /**
     * 检测是否有环（Floyd 判圈）。
     * 输入：ListNode head
     * 输出：boolean
     */
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    // =========================
    // 调试输出
    // =========================

    /**
     * 转字符串（注意：若有环会无限循环，所以内部做了步数上限保护）
     * 输入：ListNode head
     * 输出：String
     */
    public static String toString(ListNode head) {
        if (head == null) return "null";
        StringBuilder sb = new StringBuilder();
        ListNode cur = head;

        // 防止误传环形链表导致死循环：最多走 length+5 或 10000 步（取较小保护）
        int maxSteps = Math.min(10000, length(head) + 5);
        int steps = 0;

        while (cur != null && steps++ < maxSteps) {
            sb.append(cur.val);
            cur = cur.next;
            if (cur != null) sb.append(" -> ");
        }
        if (cur != null) sb.append(" -> ...");
        return sb.toString();
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    // =========================
    // 简单自测
    // =========================
    public static void main(String[] args) {
        ListNode head = ListNode.fromArray(new int[]{1, 2, 3, 4});
        System.out.println("list: " + ListNode.toString(head));
        System.out.println("len: " + ListNode.length(head));
        System.out.println("k=3: " + ListNode.getKth(head, 3).val);
        System.out.println("arr: " + Arrays.toString(ListNode.toArray(head)));
        System.out.println("rev: " + ListNode.toString(ListNode.reverse(head)));
    }
}

