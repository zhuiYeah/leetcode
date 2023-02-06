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


/**
 * 给你一棵 完整二叉树 的根
 * 完整二叉树 是每个节点有 0 个或者 2 个孩子的二叉树。
 * <p>
 * 叶子节点 要么值为 0 要么值为 1 ，其中 0 表示 False ，1 表示 True 。
 * 非叶子节点 要么值为 2 要么值为 3 ，其中 2 表示逻辑或 OR ，3 表示逻辑与 AND 。
 */


class derfer {
    public boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) return root.val != 0;
        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);
        if (root.val == 2) return left || right;
        else return left && right;
    }
}
