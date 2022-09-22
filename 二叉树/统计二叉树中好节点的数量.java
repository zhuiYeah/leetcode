package 二叉树;

//秒杀
public class 统计二叉树中好节点的数量 {
    int res = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, -1000000);
        return res;
    }

    public void dfs(TreeNode root, int curMax) {
        if (root == null) return;
//        if (root.val >= curMax) {
//            res++;
//            dfs(root.left, root.val);
//            dfs(root.right, root.val);
//        } else {
//            dfs(root.left, curMax);
//            dfs(root.right, curMax);
//        }
        //本题curMax作为局部变量，还有一种写法
        if (root.val >= curMax) {
            res++;
            curMax = root.val;
        }
        dfs(root.left, curMax);
        dfs(root.right, curMax);
    }
}
