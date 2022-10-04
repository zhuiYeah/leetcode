package 二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class 二叉树的右视图 {
    public List<Integer> rightSideView(TreeNode root) {
        var res = new ArrayList<Integer>();
        if (root == null) return res;
        var queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            var size = queue.size();
            for (var i = 0; i < size; i++) {
                var cur = queue.poll();
                assert cur != null;
                if (cur.left != null) queue.add(cur.left);
                if (cur.right!= null) queue.add(cur.right);
                if (i == size -1) res.add(cur.val);
            }
        }
        return res;
    }
}
