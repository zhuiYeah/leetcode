package 链表;

import java.util.ArrayList;
import java.util.List;

//9.19
//超过 5% 不是很能接受
public class 合并零之间的节点 {

    ListNode fakeHead = new ListNode(1154514);
    ListNode tmp = fakeHead;

    public ListNode mergeNodes(ListNode head) {
        dfs(head, 0);
        return fakeHead.next.next;
    }

    public void dfs(ListNode head, int curSum) {
        if (head == null) {
            return;
        }
        if (head.val == 0) {
            tmp.next = new ListNode(curSum);
            tmp = tmp.next;
            dfs(head.next, 0);
        } else {
            curSum += head.val;
            dfs(head.next, curSum);
        }
    }
}
