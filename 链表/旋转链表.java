package 链表;

public class 旋转链表 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int n = getLen(head);
        k = k % n;
        if (k==0) return head;
        var slow = head;
        var fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        var newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }

    public int getLen(ListNode head) {
        if (head == null) return 0;
        return getLen(head.next) + 1;
    }
}
