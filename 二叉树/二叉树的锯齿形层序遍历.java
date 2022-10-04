package 二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class 二叉树的锯齿形层序遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        var res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        var queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            var size = queue.size();
            var curLayer = new ArrayList<Integer>();
            for (var i = 0; i < size; i++) {
                var node = queue.poll();
                assert node != null;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                curLayer.add(node.val);
            }
            res.add(curLayer);
        }
        for (int i = 1; i < res.size(); i += 2) {
            int len = res.get(i).size();
            for (int j = 0; j < len / 2; j++) {
                int tmp = res.get(i).get(j);
                res.get(i).set(j, res.get(i).get(len - j - 1));
                res.get(i).set(len - j - 1, tmp);
            }
        }
        return res;
    }
}
