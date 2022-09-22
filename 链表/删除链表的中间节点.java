package 链表;

//快慢指针最经典的题目
public class 删除链表的中间节点 {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;
        var fakeHead = new ListNode(114514, head);
        var fast = fakeHead.next.next;
        var slow = fakeHead;
        while (fast != null) {
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                fast = null;
            }
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return fakeHead.next;
    }
}
