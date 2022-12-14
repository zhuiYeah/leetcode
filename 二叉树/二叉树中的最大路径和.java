package 二叉树;

//在递归过程中做些什么（处理最终结果），并向上返回一些信息的 经典题目
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


class de {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        max = Math.max(max, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}


//剑指offer
class fefe {
    int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        dfs(root);
        return max;
    }

    //每个节点向上返回该节点能为父节点提供的最大价值，每个节点都计算经过自己的最大路径
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));
        max = Math.max(max, root.val + left + right);
        return Math.max(left, right) + root.val;
    }

}