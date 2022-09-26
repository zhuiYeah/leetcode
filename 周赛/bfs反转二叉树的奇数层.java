package 周赛;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class bfs反转二叉树的奇数层 {
    public TreeNode reverseOddLevels(TreeNode root) {
        var queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        int layer = -1;
        while (!queue.isEmpty()) {
            layer++;
            int n = queue.size();
            var value = new ArrayList<Integer>();
            var node = new ArrayList<TreeNode>();
            for (int i = 0; i < n; i++) {
                var cur = queue.poll();
                assert cur != null;
                value.add(0,cur.val);
                node.add(cur);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            if (layer % 2 == 1) {
                for (int i = 0;i<value.size(); i++){
                    node.get(i).val = value.get(i);
                }
            }
        }
        return root;
    }
}
