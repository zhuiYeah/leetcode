package 动态规划;

//来自第314场周赛
//一眼dfs超时 ，其他的不会

//动态规划
public class _矩阵中和能被K整除的路径 {
    public int numberOfPaths(int[][] grid, int k) {
        final int mod = (int) (1e9 + 7);
        int m = grid.length, n = grid[0].length;

        //定义 dp[i][j][v] 表示从左上走到 (i,j)，且路径和mod k 的结果为 v 时的 路径数
        var dp = new int[m + 1][n + 1][k];
        int pre = grid[0][0] % k;
        dp[0][0][pre] = 1;
        for (int j = 1; j < n; j++) {
            pre = (pre + grid[0][j]) % k;
            dp[0][j][pre] = 1;
        }

        pre = grid[0][0] % k;
        for (int i = 1; i < m; i++) {
            pre = (pre + grid[i][0]) % k;
            dp[i][0][pre] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                var leftAndUp = new int[k];
                for (int x = 0; x < k; x++) {
                    leftAndUp[x] = (dp[i - 1][j][x] + dp[i][j - 1][x]) % mod;
                }
                for (int x = 0; x < k; x++) {
                    //if (leftAndUp[x] != 0) {
                        int val = (grid[i][j] + x) % k;
                        dp[i][j][val] = leftAndUp[x] % mod;
                    //}
                }
            }
        }
        return dp[m - 1][n - 1][0];
    }
}
