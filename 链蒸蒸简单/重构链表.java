package 链蒸蒸简单;

//删掉链表中所有的偶数节点
public class 重构链表 {
    public ListNode reContruct(ListNode head) {
        var fakeHead = new ListNode(114515);
        fakeHead.next = head;
        return f(fakeHead).next;

    }

    public ListNode f(ListNode head) {
        if (head == null) return null;
        head.next = f(head.next);
        if (head.val % 2 ==0 ){
            return head.next;
        }
        return head;
    }
}
