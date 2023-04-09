package 动态规划;

public class 礼物的最大价值 {
    public int maxValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        var dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //更新dp[i][j]，对应的点为grid[i-1][j-1]
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }
}
