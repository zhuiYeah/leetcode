package 二叉树;

public class 二叉树中的最大路径和 {
    int res;

    public int maxPathSum(TreeNode root) {
        res = root.val;
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) { //向父节点返回本子树能提供的最大路径和
        if (root == null) return 0;
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        res = Math.max(res, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
