package 二叉树;

import java.util.ArrayDeque;
import java.util.Queue;

public class bfs二叉树的最大宽度 {
    public int widthOfBinaryTree(TreeNode root) {
        int res = 0;
        root.val = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int start = 0;
            int end = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (i == 0) {
                    start = cur.val;
                }
                if (i == size - 1) {
                    end = cur.val;
                }
                if (cur.left != null) {
                    cur.left.val = 2 * cur.val;
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    cur.right.val = 2 * cur.val + 1;
                    queue.add(cur.right);
                }
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }
}
