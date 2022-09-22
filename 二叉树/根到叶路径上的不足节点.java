package 二叉树;

public class 根到叶路径上的不足节点 {
    int LIMIT;

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        LIMIT = limit;
        return dfs(root, 0);
    }

    public TreeNode dfs(TreeNode root, int sum) {
        if (root == null) return null;
        //原始叶子结点
        if (root.left == null && root.right == null) {
            if (sum + root.val < LIMIT) {
                return null;
            } else {
                return root;
            }
        }
        root.left = dfs(root.left, sum + root.val);
        root.right = dfs(root.right, sum + root.val);
        //原本不是叶子节点的节点如果变成了叶子节点，也需要删除（虽然从题意并没有读出来这一点）
        if (root.left == null && root.right == null) {
            return null;
        }
        return root;
    }
}
