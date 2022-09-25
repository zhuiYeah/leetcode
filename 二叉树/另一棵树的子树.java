package 二叉树;

public class 另一棵树的子树 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;
//        if (isSame(root, subRoot)) return true;
//        if (isSubtree(root.left, subRoot)) return true;
//        if (isSubtree(root.right, subRoot)) return true;
//        return false;
        return isSame(root, subRoot) || isSubtree(root.right, subRoot) || isSubtree(root.left, subRoot);
    }

    public boolean isSame(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.val != b.val) return false;
        return isSame(a.left, b.left) && isSame(a.right, b.right);
    }
}
