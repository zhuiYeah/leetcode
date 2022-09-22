package 二叉树;

public class 单值二叉树 {
    int value;

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        value = root.val;
        return dfs(root);
    }

    public boolean dfs(TreeNode root) {
        if (root == null) return true;
        if (root.val != value) return false;
        if (!dfs(root.left)) {
            return false;
        }
        if (!dfs(root.right)) {
            return false;
        }
        return true;
    }
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        if (root.left != null) {
            if (root.val != root.left.val) {
                return false;
            }
        }
        if (root.right != null) {
            if (root.val != root.right.val) {
                return false;
            }
        }
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }
}

