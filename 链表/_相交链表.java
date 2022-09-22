package 链表;

public class _相交链表 {
    //双指针 互换赛道
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        var PA = headA;
        var PB = headB;
        if (PA == null || PB == null) return null;
        while (PA != PB) {
            if (PA == null) {
                PA = headB;
            } else {
                PA = PA.next;
            }
            if (PB == null) {
                PB = headA;
            } else {
                PB = PB.next;
            }
        }
        return PA;
    }
}
