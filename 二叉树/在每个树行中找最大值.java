package 二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

//剑指offer
public class 在每个树行中找最大值 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        var queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                var cur = queue.poll();
                max = Math.max(max, cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            result.add(max);
        }
        return result;
    }
}
