package 链表;

public class 两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0;
        var fakeHead = new ListNode(0);
        var tmp = fakeHead;
        while (l1 != null && l2 != null) {
            int a = l1.val;
            int b = l2.val;
            int sum = a + b + add;
            add = sum / 10;
            sum %= 10;
            tmp.next = new ListNode(sum);
            tmp = tmp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int a = l1.val;
            int sum = a + add;
            add = sum / 10;
            sum %= 10;
            tmp.next = new ListNode(sum);
            tmp = tmp.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int a = l2.val;
            int sum = a + add;
            add = sum / 10;
            sum %= 10;
            tmp.next = new ListNode(sum);
            tmp = tmp.next;
            l2 = l2.next;
        }
        if (add != 0) {
            tmp.next = new ListNode(add);
        }
        return fakeHead.next;

    }
}
