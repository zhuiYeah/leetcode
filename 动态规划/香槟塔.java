package 动态规划;

public class 香槟塔 {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[100][100];
        dp[0][0] = (double) poured;
        for (int i = 1; i < 100; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (j == 0)
                    dp[i][j] = Math.max((dp[i - 1][j] - 1) / 2.0, 0);
                else if (j == i)
                    dp[i][j] = Math.max(0, (dp[i - 1][j - 1] - 1) / 2.0);
                else
                    dp[i][j] = Math.max(0, (dp[i - 1][j - 1] - 1) / 2.0) + Math.max(0, (dp[i - 1][j] - 1) / 2.0);
            }
        }
        return dp[query_row][query_glass] > 1 ? 1 : dp[query_row][query_glass];
    }
}
