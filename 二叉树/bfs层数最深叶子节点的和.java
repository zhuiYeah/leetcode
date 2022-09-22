package 二叉树;

import java.util.ArrayDeque;
import java.util.Queue;

public class bfs层数最深叶子节点的和 {
    int res;

    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>(); //java内置的队列
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            int curLayerSum = 0;
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                curLayerSum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res = curLayerSum;
        }
        return res;
    }
}

