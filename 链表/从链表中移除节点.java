package 链表;


public class 从链表中移除节点 {
    int rightMax = Integer.MIN_VALUE;

    public ListNode removeNodes(ListNode head) {
        return f(head);
    }


    public ListNode f(ListNode head) {
        if (head == null) return null;
        head.next = f(head.next);
        if (rightMax > head.val) {
            return head.next;
        } else {
            rightMax = head.val;
            return head;
        }
    }
}
