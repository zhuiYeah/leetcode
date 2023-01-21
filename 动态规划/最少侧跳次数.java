package 动态规划;

public class 最少侧跳次数 {
    public int minSideJumps(int[] obstacles) {
        final int INF = 0x3f3f3f;
        int n = obstacles.length;
        //dp[x][y] : 到达x y 位置的最小侧跳次数
        int[][] dp = new int[n][4];
        dp[0][1] = 1;
        dp[0][2] = 0;
        dp[0][3] = 1;
        for (int i = 1; i < n; i++) {
            if (obstacles[i] == 0) {
                dp[i][1] = dp[i - 1][1];
                dp[i][2] = dp[i - 1][2];
                dp[i][3] = dp[i - 1][3];
                int min = Math.min(dp[i][1], Math.min(dp[i][2], dp[i][3]));
                dp[i][1] = Math.min(dp[i][1], min + 1);
                dp[i][2] = Math.min(dp[i][2], min + 1);
                dp[i][3] = Math.min(dp[i][3], min + 1);
            } else if (obstacles[i] == 1) {
                dp[i][1] = INF;
                dp[i][2] = dp[i - 1][2];
                dp[i][3] = dp[i - 1][3];
                int min = Math.min(dp[i][2], dp[i][3]);
                dp[i][2] = Math.min(dp[i][2], min + 1);
                dp[i][3] = Math.min(dp[i][3], min + 1);
            } else if (obstacles[i] == 2) {
                dp[i][2] = INF;
                dp[i][1] = dp[i - 1][1];
                dp[i][3] = dp[i - 1][3];
                int min = Math.min(dp[i][1], dp[i][3]);
                dp[i][1] = Math.min(dp[i][1], min + 1);
                dp[i][3] = Math.min(dp[i][3], min + 1);
            } else {
                dp[i][3] = INF;
                dp[i][1] = dp[i - 1][1];
                dp[i][2] = dp[i - 1][2];
                int min = Math.min(dp[i][1], dp[i][2]);
                dp[i][1] = Math.min(dp[i][1], min + 1);
                dp[i][2] = Math.min(dp[i][2], min + 1);
            }
        }

        return Math.min(dp[n - 1][1], Math.min(dp[n - 1][2], dp[n - 1][3]));
    }
}
