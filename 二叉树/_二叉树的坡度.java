package 二叉树;

public class _二叉树的坡度 {
    int tilt; //记录坡度

    public int findTilt(TreeNode root) {
        dfs(root);
        return tilt;
    }

    public int dfs(TreeNode root) { //返回的是本树以及本子树的和
        if (root == null) { //空节点和为0
            return 0;
        }
        if (root.left == null && root.right == null) { //叶子节点的坡度为0,所以不需要处理tilt
            return root.val;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        tilt += Math.abs(left - right);
        return left + right + root.val; ///返回本树以及本子树的和

    }
}
