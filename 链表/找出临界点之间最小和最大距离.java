package 链表;

import java.util.ArrayList;
import java.util.List;

public class 找出临界点之间最小和最大距离 {
    int index = 0;
    List<Integer> list = new ArrayList<Integer>();

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        dfs(head.next, head.val);
        if (list.size() <= 1) {
            return new int[]{-1, -1};
        }
        int max = list.get(list.size() - 1) - list.get(0);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            min = Math.min(min, list.get(i) - list.get(i - 1));
        }
        return new int[]{min, max};
    }

    public void dfs(ListNode head, int frontVal) {
        if (head.next == null) return;
        if (head.val > frontVal && head.val > head.next.val) list.add(index);
        if (head.val < frontVal && head.val < head.next.val) list.add(index);
        index++;
        dfs(head.next, head.val);
    }
}
