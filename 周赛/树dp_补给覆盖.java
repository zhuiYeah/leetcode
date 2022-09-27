package 周赛;

//树形dp
public class 树dp_补给覆盖 {
    public int minSupplyStationNumber(TreeNode root) {
        int[] dp = dfs(root);
        return Math.min(dp[0], dp[1]);
    }

    public int[] dfs(TreeNode root) {
        int[] dp = new int[2];
        //dp[0] :该节点不放置补给箱 所需要的最小补给次数
        //dp[1] ： 该节点放置补给箱 所需要的最小补给次数
        if (root == null) {
            return dp;
        }
        var left = dfs(root.left);
        var right = dfs(root.right);
        dp[0] = Math.min(left[0] + right[1], Math.min(left[1] + right[0], left[1] + right[1]));
        dp[1] = Math.min(left[0], left[1]) + Math.min(right[0], right[1]) + 1;
        return dp;
    }
}


////////////////////////////////////////////////////////////////////////
//子节点需要向父节点返回三个信息
//0:我已经安装了监视器
//1：可观测
//2：不可观测
class ede3wfc {
    int ans;

    public int minSupplyStationNumber(TreeNode root) {
        int x = dfs(root);
        if (x == 2) ans++;
        return ans;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 1;
        int left = dfs(root.left), right = dfs(root.right);
        if (left == 2 || right == 2) {
            ans++;
            return 0;
        } else if (left == 0 || right == 0) {
            return 1;
        } else {
            return 2;
        }
    }
}
