package 排序;


import java.util.Arrays;
import java.util.PriorityQueue;

public class 堆_合并k个升序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        var pq = new PriorityQueue<ListNode>((a, b) -> {
            return a.val - b.val;
        });
        for (ListNode list : lists) {
            if (list == null) continue;
            pq.add(list);
        }
        var fakeHead = new ListNode();
        var tmp = fakeHead;
        while (!pq.isEmpty()) {
            var head = pq.poll();
            tmp.next = new ListNode(head.val);
            tmp = tmp.next;
            if (head.next == null) continue;
            pq.add(head.next);
        }
        return fakeHead.next;
    }
}
