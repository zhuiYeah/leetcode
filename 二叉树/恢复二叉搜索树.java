package 二叉树;

public class 恢复二叉搜索树 {
    //pre存放中序遍历当前节点的前一个节点
    //min记录失序节点中的最小节点
    //max记录失序节点中的最大节点
    TreeNode pre = new TreeNode(Integer.MIN_VALUE);
    TreeNode min = new TreeNode(Integer.MAX_VALUE);
    TreeNode max = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        inorder(root);
        int tmp = min.val;
        min.val = max.val;
        max.val = tmp;
    }
    
    public void inorder(TreeNode root){
        if (root ==null) return;
        inorder(root.left);
        if (root.val< pre.val) {
            if (root.val < min.val) min = root;
            if (pre.val>max.val) max = pre;
        }
        pre = root;
        inorder(root.right);
    }
}
