package 二叉树;

public class 检查平衡性 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(depth(root.left)-depth(root.right))>1) {
            return false;
        }
        if (!isBalanced(root.left)){
            return false;
        }
        if (!isBalanced(root.right)){
            return false;
        }
        return true;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(depth(root.left), depth(root.right));
    }

}
