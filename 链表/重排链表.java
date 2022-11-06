package 链表;

//1 - 2 - 3 -4  ----》 1-4-2-3
//递归 越写越爽
public class 重排链表 {
    ListNode pre;
    ListNode prepre;

    public void reorderList(ListNode head) {
        prepre = new ListNode(11, head);
        pre = head;
        dfs(head);
    }

    public boolean dfs(ListNode cur) {
        if (cur == null) {
            return false;
        }
        if (dfs(cur.next)) return true;
        if (cur == pre) {
            prepre.next = cur;
            cur.next = null;
            return true;
        }
        prepre.next = pre;
        prepre = cur;
        cur.next = null;
        var tmp = pre.next;
        pre.next = cur;
        pre = tmp;
        if (pre == cur) return true;
        return false;
    }

}


//剑指offer
class ecwdew {
    private ListNode pre;
    private ListNode cur;

    public void reorderList(ListNode head) {
        pre = new ListNode();
        pre.next = head;
        cur = head;
        f(head);
    }

    private boolean f(ListNode head) {
        if (head == null) return false;
        if (f(head.next)) return true;
        if (cur == head || cur.next == head) {
            pre.next = cur;
            head.next = null;
            return true;
        }
        var tmp = cur;
        cur = cur.next;
        tmp.next = head;
        head.next = null;
        pre.next = tmp;
        pre = head;
        return false;
    }
}
