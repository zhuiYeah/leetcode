package 二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

//剑指offer
//利用数组储存完全二叉树，可以快速从子节点追溯到父节点（前提是一定要是完全二叉树哦）
public class 完全二叉树插入器 {

}

class CBTInserter {
    private List<TreeNode> tree;

    public CBTInserter(TreeNode root) {
        tree = new ArrayList<TreeNode>();
        if (root == null) return;
        var queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            var cur = queue.poll();
            tree.add(cur);
            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
        }
    }

    public int insert(int v) {
        var newt = new TreeNode(v);
        tree.add(newt);
        int fatherindex = (tree.size() - 1 - 1) / 2;
        if (tree.get(fatherindex).left == null) {
            tree.get(fatherindex).left = newt;
        } else {
            tree.get(fatherindex).right = newt;
        }
        return tree.get(fatherindex).val;
    }

    public TreeNode get_root() {
        return tree.get(0);
    }
}

