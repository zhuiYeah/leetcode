package 二叉树;

public class 递增顺序搜索树 {
    TreeNode fakeRoot = new TreeNode();
    TreeNode tmp = fakeRoot;

    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        return fakeRoot.right;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        tmp.right = new TreeNode(root.val);
        tmp = tmp.right;
        inorder(root.right);
    }
}


//剑指offer
class fcede {

    private TreeNode fakeRoot = new TreeNode();
    private TreeNode tmp = fakeRoot;

    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        return fakeRoot.right;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        tmp.right = new TreeNode(root.val);
        tmp = tmp.right;
        dfs(root.right);
    }

}
