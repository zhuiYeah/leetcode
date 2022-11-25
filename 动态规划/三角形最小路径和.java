package 动态规划;

import java.util.List;

public class 三角形最小路径和 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        //if (n == 1) return triangle.get(0).get(0);
        var dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }
        int min = dp[n - 1][0];
        for (int i = 0; i < n; i++) min = Math.min(min, dp[n - 1][i]);
        return min;
    }
}
