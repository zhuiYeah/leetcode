package 二叉树;

//剑指offer
public class 求根节点到叶节点数字之和 {
    int totalsum;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return totalsum;
    }

    public void dfs(TreeNode root, int sum) {
        if (root == null) return;
        sum = 10 * sum + root.val;
        if (root.left == null && root.right == null) {
            totalsum += sum;
            return;
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
    }
}
