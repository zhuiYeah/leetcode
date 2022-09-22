package 二叉树;

public class 节点与其祖先之间的最大差值 {
    int res;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return res;
    }

    //每层都必须维护一个该节点独有的最大值最小值，所以max 、 min作为局部变量传递
    public void dfs(TreeNode root, int max, int min) {
        if (root == null) return;
        res = Math.max(Math.abs(max - root.val), Math.max(res, Math.abs(min - root.val)));
        if (root.val > max) {
            max = root.val;
        }
        if (root.val < min) {
            min = root.val;
        }
        dfs(root.left, max, min);
        dfs(root.right, max, min);
    }
}
