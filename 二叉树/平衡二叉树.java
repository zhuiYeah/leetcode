package 二叉树;

public class 平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = maxdepth(root.left);
        int right = maxdepth(root.right);
        if (Math.abs(left - right) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxdepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxdepth(root.left), maxdepth(root.right)) + 1;
    }
}
