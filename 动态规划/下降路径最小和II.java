package 动态规划;

import java.util.PriorityQueue;

//O n^3 超暴力
public class 下降路径最小和II {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        var dp = new int[n][n]; //dp[i][j]表示下降到grid[i][j]位置的最小和
        for (int j = 0; j < n; j++) dp[0][j] = grid[0][j];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (k == j) continue;
                    min = Math.min(min, dp[i - 1][k]);
                }
                dp[i][j] = min + grid[i][j];
            }
        }
        int min = dp[n - 1][0];
        for (int i = 1; i < n; i++) min = Math.min(min, dp[n - 1][i]);
        return min;
    }
}

//o n^2 ,用容量为2的堆维护一个 最大元素 和 第二大元素
class dew {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        var dp = new int[n][n]; //dp[i][j]表示下降到grid[i][j]位置的最小和
        var pq = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int j = 0; j < n; j++) {
            dp[0][j] = grid[0][j];
            if (pq.size() == 2) {
                if (dp[0][j] < pq.peek()) {
                    pq.poll();
                    pq.offer(dp[0][j]);
                }
            } else {
                pq.offer(dp[0][j]);
            }
        }
        for (int i = 1; i < n; i++) {
            int secondmin = pq.poll(), min = pq.poll();
            for (int j = 0; j < n; j++) {
                if (dp[i - 1][j] == min) dp[i][j] = secondmin + grid[i][j];
                else dp[i][j] = min + grid[i][j];
                if (pq.size() == 2) {
                    if (dp[i][j] < pq.peek()) {
                        pq.poll();
                        pq.offer(dp[i][j]);
                    }
                } else {
                    pq.offer(dp[i][j]);
                }
            }
        }
        int min = dp[n - 1][0];
        for (int i = 1; i < n; i++) min = Math.min(min, dp[n - 1][i]);
        return min;
    }
}
