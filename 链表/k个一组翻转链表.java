package 链表;

//写了蛮久的
public class k个一组翻转链表 {
    int k;

    public ListNode reverseKGroup(ListNode head, int k) {
        this.k = k;
        return dfs(head, head, 1);
    }

    //标记一段链表反转前的尾巴节点（反转后的头节点）
    ListNode tail;

    //函数向上层返回本节链表反转后的头节点
    public ListNode dfs(ListNode cur, ListNode head, int layer) {
        if (cur == null) return null;
        //下一段链表的头节点
        if (layer % k == 0) {
            var nextHead = dfs(cur.next, cur.next, layer + 1);
            reverse(head, cur);
            head.next = nextHead;
            tail = cur;
            return cur;
        } else {
            dfs(cur.next, head, layer + 1);
            return tail == null ? cur : tail;
        }

    }

    public ListNode reverse(ListNode head, ListNode tail) {
        if (head == null || head.next == null || head == tail) {
            return head;
        }
        var newHead = reverse(head.next, tail);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
