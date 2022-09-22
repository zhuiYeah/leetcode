package 动态规划;

//只能进行一次买卖
public class 买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        //dp[i][0] : 第i天的手中持有股票的最大收益
        //dp[i][1] : 第i天手中不持有股票的最大收益
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        int max = 0;
        for (int i = 1; i < n; i++) {
            //今天手中有股票，要么是今天买的，要么是前一天就买好了
            dp[i][0] = Math.max(-prices[i], dp[i - 1][0]);
            //今天手中没股票，要么前一天就没有，要么前一天有今天买了
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[n - 1][1];
    }
}
