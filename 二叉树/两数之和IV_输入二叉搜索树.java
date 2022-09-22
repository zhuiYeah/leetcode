package 二叉树;

import java.util.HashSet;
import java.util.Set;

public class 两数之和IV_输入二叉搜索树 {
    int Target;
    Set<Integer> set = new HashSet<Integer>();

    public boolean findTarget(TreeNode root, int k) {
        Target = k;
        return dfs(root);
    }

    public boolean dfs(TreeNode root) {
        if (root == null) return false;
        if (set.contains(Target - root.val)) {
            return true;
        } else {
            set.add(root.val);
        }
        if (dfs(root.left)) {
            return true;
        }
        if (dfs(root.right)) {
            return true;
        }
        return false;
    }
}
