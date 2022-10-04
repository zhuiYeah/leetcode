package 链表;

//递归
//高铁上写的
public class 两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        return dfs(head, 1, null);
    }

    public ListNode dfs(ListNode head, int layer, ListNode father) {
        if (head == null) return null;
        var newHead = dfs(head.next, layer + 1, head);
        if (layer % 2 == 0) {
            father.next = newHead;
            head.next = father;
            return head;
        } else {
            return newHead == null ? head : newHead;
        }
    }
}
