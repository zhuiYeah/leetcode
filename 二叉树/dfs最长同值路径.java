package 二叉树;

//秒杀了，过程中做点什么，往上传点什么 的经典题目
public class dfs最长同值路径 {
    int res = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root, 114514); //这里传递什么值不重要，因为root节点无需在向上返回什么信息了
        return res;
    }

    public int dfs(TreeNode root, int val) { //向父亲节点返回本子树所能提供的最长相同节点路径长度
        if (root == null) return 0;
        int left = dfs(root.left, root.val);
        int right = dfs(root.right, root.val);
        res = Math.max(res, left + right);
        if (root.val == val) return Math.max(left, right) + 1;
        return 0;
    }
}


