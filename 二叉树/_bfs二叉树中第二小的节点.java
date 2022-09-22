package 二叉树;

import java.util.ArrayDeque;
import java.util.Queue;

public class _bfs二叉树中第二小的节点 {
    public int findSecondMinimumValue(TreeNode root) {
        int min = root.val;
        long secondMin = Long.MAX_VALUE;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val > min && node.val < secondMin) {
                secondMin = node.val;
            }
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        if (secondMin == Long.MAX_VALUE) {
            return -1;
        } else {
            return (int) secondMin;
        }
    }
}
