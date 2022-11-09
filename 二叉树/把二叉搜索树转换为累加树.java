package 二叉树;

//剑指offer
public class 把二叉搜索树转换为累加树 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);
        int tmp = root.val;
        root.val += sum;
        sum += tmp;
        dfs(root.left);
    }
}
