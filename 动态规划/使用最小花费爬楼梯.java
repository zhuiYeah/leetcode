package 动态规划;

public class 使用最小花费爬楼梯 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        var dp = new int[n]; //dp[i] : 从下标为i的楼梯跃起后需要的最小代价
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}
