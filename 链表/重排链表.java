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
        pre=tmp;
        if (pre == cur) return true;
        return false;
    }

}
