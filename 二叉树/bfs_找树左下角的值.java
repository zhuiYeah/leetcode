package 二叉树;

import java.util.ArrayDeque;

//剑指offer
public class bfs_找树左下角的值 {
    public int findBottomLeftValue(TreeNode root) {
        var queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        int val = 0;
        while (!queue.isEmpty()) {
            var cur = queue.poll();
            if (cur.right != null) queue.add(cur.right);
            if (cur.left != null) queue.add(cur.left);
            val = cur.val;
        }
        return val;
    }
}
