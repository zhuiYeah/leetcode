package 链表;

//链表的对撞指针，利用递归来实现
public class 链表最大孪生和 {
    ListNode node;
    int max;

    public int pairSum(ListNode head) {
        node = head;
        dfs(head);
        return max;
    }

    public void dfs(ListNode head) {
        if (head == null) return;
        dfs(head.next);
        max = Math.max(max, head.val + node.val);
        node = node.next;
    }
}
