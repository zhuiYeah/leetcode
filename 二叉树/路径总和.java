package 二叉树;

//是否存在一个从跟节点到叶子节点的路径，使得路径和为TargetSum
public class 路径总和 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == targetSum;
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
