package 二叉树;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 删点成林 {
    List<TreeNode> res = new ArrayList<TreeNode>();
    Set<Integer> set = new HashSet<Integer>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int i : to_delete) set.add(i);
        root = dfs(root);
        if (root != null) res.add(root);
        return res;
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null) return null;
        root.left = dfs(root.left);
        root.right = dfs(root.right);
        if (set.contains(root.val)) {
            if (root.left != null) res.add(root.left);
            if (root.right != null) res.add(root.right);
            return null;
        } else {
            return root;
        }
    }
}
