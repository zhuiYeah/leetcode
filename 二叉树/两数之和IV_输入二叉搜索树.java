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

//剑指offer
class fewfew {
    private int K;
    private Set<Integer> set;

    public boolean findTarget(TreeNode root, int k) {
        K = k;
        set = new HashSet<Integer>();
        return f(root);
    }

    private boolean f(TreeNode root) {
        if (root == null) return false;
        if (set.contains(K - root.val)) return true;
        set.add(root.val);
        if (f(root.left)) return true;
        if (f(root.right)) return true;
        return false;
    }
}
