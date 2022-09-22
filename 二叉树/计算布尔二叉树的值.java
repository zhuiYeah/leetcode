package 二叉树;

//后序遍历
public class 计算布尔二叉树的值 {
    public boolean evaluateTree(TreeNode root) {
        if (root.val == 1) {
            return true;
        }
        if (root.val == 0) {
            return false;
        }
        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);
        if (root.val == 2) {
            return left || right;
        }
        return left && right;
    }
}
