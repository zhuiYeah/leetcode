package 太简单了没意思;

import java.util.HashSet;
import java.util.Set;

public class 移除重复节点 {
    Set<Integer> set = new HashSet<Integer>();

    public ListNode removeDuplicateNodes(ListNode head) {
        dfs(head, null);
        return head;
    }

    public void dfs(ListNode head, ListNode father) {
        if (head == null) return;
        if (set.contains(head.val)) {
            //需要删掉该节点
            father.next = head.next;
            dfs(head.next, father);
        } else {
            //无需删掉该节点
            set.add(head.val);
            dfs(head.next, head);
        }
    }
}
