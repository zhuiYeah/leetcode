package 二叉树;

public class dfs统计值等于子树平均值的节点数 {
    int res;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return res;
    }

    public int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        var left = dfs(root.left);
        var right = dfs(root.right);
        int sum = left[0] + right[0] + root.val;
        int numOfNode = left[1] + right[1] + 1;
        if (sum / numOfNode == root.val) {
            res++;
        }
        return new int[]{sum, numOfNode};
    }
}
