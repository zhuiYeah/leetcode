package 链表;

public class 两数之和II {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        var fakeHead = new ListNode();
        var tmp = fakeHead;
        var carry = 0;
        while (l1 != null && l2 != null) {
            carry += l1.val + l2.val;
            tmp.next = new ListNode(carry % 10);
            tmp = tmp.next;
            carry /= 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            carry += l1.val;
            tmp.next = new ListNode(carry % 10);
            tmp = tmp.next;
            carry /= 10;
            l1 = l1.next;
        }
        while (l2 != null) {
            carry += l2.val;
            tmp.next = new ListNode(carry % 10);
            tmp = tmp.next;
            carry /= 10;
            l2 = l2.next;
        }
        if (carry != 0) tmp.next = new ListNode(carry);
        return reverse(fakeHead.next);
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        var newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}


//剑指offer
class dcw {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        var fakeHead = new ListNode();
        var tmp = fakeHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            tmp.next = new ListNode(carry % 10);
            tmp = tmp.next;
            carry /= 10;
        }
        if (carry != 0) tmp.next = new ListNode(carry);
        return reverse(fakeHead.next);
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        var newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
