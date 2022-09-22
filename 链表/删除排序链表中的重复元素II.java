package 链表;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 删除排序链表中的重复元素II {
    //节点值 ->  父节点 (只映射第一次出现的节点值 -》 他的父节点)
    Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();

    public ListNode deleteDuplicates(ListNode head) {
        var fakeHead = new ListNode(114154, head);
        dfs(head, fakeHead, 114514);
        return fakeHead.next;
    }

    public void dfs(ListNode head, ListNode father, int fatherVal) {
        if (head == null) return;
        if (head.val != fatherVal) {
            //该点不需要被删除
            map.put(head.val, father);
            dfs(head.next, head, head.val);
        } else {
            //该点需要被删除，这牵连了之前所有的同值点
            var grandF = map.get(head.val);
            grandF.next = head.next;
            dfs(grandF.next, grandF, head.val);
        }
    }
}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//----------------------------------------------------------------  --------------------------------
//本方法用于删除所有链表（非排序）的重复节点
class dwdwdw {
    Set<Integer> set = new HashSet<>();

    public ListNode deleteDuplicates(ListNode head) {
        var tmp = head;
        Map<Integer, Integer> map = new HashMap<>();
        while (tmp != null) {
            map.put(tmp.val, map.getOrDefault(tmp.val, 0) + 1);
            tmp = tmp.next;
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                set.add(entry.getKey());
            }
        }
        var fakeHead = new ListNode(114514, head);
        dfs(head, fakeHead);
        return fakeHead.next;
    }

    public void dfs(ListNode head, ListNode father) {
        if (head == null) return;
        if (set.contains(head.val)) {
            father.next = head.next;
            dfs(father.next, father);
        } else {
            dfs(head.next, head);
        }
    }
}
