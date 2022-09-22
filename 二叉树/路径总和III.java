package 二叉树;

//dfs中的dfs，在遍历一次树的过程中再从节点开始进行一次dfs
//时间复杂度O(N^2),N为二叉树节点个数
public class 路径总和III {
    int targetSum;
    int res;

    public int pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        preorder(root);
        return res;
    }

    public void dfs(TreeNode root, long curSum) {
        if (root == null) return;
        curSum += root.val;
        if (curSum == targetSum) {
            res++;
        }
        dfs(root.left, curSum);
        dfs(root.right, curSum);
    }

    public void preorder(TreeNode root) {
        if (root == null) return;
        dfs(root, 0);
        preorder(root.left);
        preorder(root.right);
    }
}
