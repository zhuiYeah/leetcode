package 动态规划;

import java.util.Arrays;

public class 买卖股票的最佳时机含冷冻期 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][4];
        //dp表示各个状态的最大收益
        //0 :手中持有股票状态
        //1：手中不持有股票（当天卖出股票状态）
        //2：手中不持有股票（非当天卖出股票，且非冷冻期）(即今天昨天未发生卖出，卖出发生在前天或者更久之前)
        //3：手中不持有股票（昨天刚交易完成，今天是冷冻期）
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][2] - prices[i], Math.max(dp[i - 1][0], dp[i - 1][3] - prices[i]));
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][3], dp[i - 1][2]);
            dp[i][3] = dp[i - 1][1];
        }
        Arrays.sort(dp[n - 1]);
        return dp[n - 1][3];
    }
}
