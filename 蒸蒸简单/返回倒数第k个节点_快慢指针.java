package 蒸蒸简单;

public class 返回倒数第k个节点_快慢指针 {
    public int kthToLast(ListNode head, int k) {
        var fast = head;
        var slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        assert slow != null;
        return slow.val;
    }
}
