package 二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class bfs特定深度节点链表 {
    public ListNode[] listOfDepth(TreeNode tree) {
        var queue = new ArrayDeque<TreeNode>();
        queue.add(tree);
        var result = new ArrayList<ListNode>();
        while (!queue.isEmpty()) {
            int n = queue.size();
            var fakeHead = new ListNode(114514, null);
            var tmp = fakeHead;
            for (int i = 0; i < n; i++) {
                var curNode = queue.poll();
                assert curNode != null;
                tmp.next = new ListNode(curNode.val);
                tmp = tmp.next;
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            result.add(fakeHead.next);
        }
        var res = new ListNode[result.size()];
        result.toArray(res);
        return res;
    }
}
