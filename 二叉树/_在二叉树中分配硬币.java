package 二叉树;

//在递归中处理结果，并在递归中向上返回一些东西
public class _在二叉树中分配硬币 {
    int res = 0;

    public int distributeCoins(TreeNode root) {
        postorder(root);
        return res;
    }

    public int postorder(TreeNode root) { //返回本节点能向上提供的硬币或者向上需要的硬币
        if (root == null) return 0;
        int left = postorder(root.left);
        int right = postorder(root.right);
        res += Math.abs(left) + Math.abs(right);
        return root.val - 1 + left + right;
    }
}
