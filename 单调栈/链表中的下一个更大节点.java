package 单调栈;


import java.util.ArrayDeque;
import java.util.ArrayList;

public class 链表中的下一个更大节点 {
    public int[] nextLargerNodes(ListNode head) {
        var list = new ArrayList<Integer>();
        for (var tmp = head; tmp != null; tmp = tmp.next) {
            list.add(tmp.val);
        }
        int[] res = new int[list.size()];
        var stack = new ArrayDeque<Integer>();
        for (int i = 0; i < list.size(); i++) {
            while (!stack.isEmpty() && list.get(i) > list.get(stack.peek())) {
                int index = stack.pop();
                res[index] = list.get(i);
            }
            stack.push(i);
        }
        return res;
    }
}
