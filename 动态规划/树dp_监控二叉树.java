package 动态规划;

public class 树dp_监控二叉树 {
    int ans = 0;
    public int minCameraCover(TreeNode root) {
        if (dfs(root)==2) ans++;
        return ans;
    }

    //向上层传递本层的信息有助于上层做出决策
    // 0 ： 安装了监控
    //1 :可观测，但是未安装监控
    //2 ： 不可观测
    public int dfs(TreeNode root) {
        if (root == null) return 1;
        int left = dfs(root.left), right = dfs(root.right);
        if (left == 2 || right == 2) {
            ans ++;
            return 0;
        }else if (left ==0 || right ==0){
            return 1;
        }else{
            return 2;
        }
    }
}
