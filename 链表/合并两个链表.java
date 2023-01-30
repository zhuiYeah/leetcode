package 链表;

public class 合并两个链表 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        var dummyHead = new ListNode();
        var tmp = dummyHead;
        int i = 0;
        while (i < a) {
            tmp.next = list1;
            tmp = tmp.next;
            list1 = list1.next;
            i++;
        }
        tmp.next = list2;
        while (tmp.next != null) tmp = tmp.next;
        while (i <= b) {
            list1 = list1.next;
            i++;
        }
        while (list1 != null) {
            tmp.next = list1;
            tmp = tmp.next;
            list1 = list1.next;
        }
        return dummyHead.next;
    }
}
