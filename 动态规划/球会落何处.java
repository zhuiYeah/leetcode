package 动态规划;

//模拟 动态规划
public class 球会落何处 {
    public static int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        //dp[i][j] : 经过第i行之后，j号小球所在列的位置为dp[i][j]
        //初始化dp数组
        for (int j = 0; j < n; j++) {
            if (j == 0 && grid[0][j] == -1) {
                dp[0][0] = -1;
            } else if (j == n - 1 && grid[0][j] == 1) {
                dp[0][n - 1] = -1;
            } else {
                if (grid[0][j] == 1 && grid[0][j + 1] == 1) {
                    dp[0][j] = j + 1;
                } else if (grid[0][j] == -1 && grid[0][j - 1] == -1) {
                    dp[0][j] = j - 1;
                } else {
                    dp[0][j] = -1;
                }
            }
        }
        for (int j = 0; j < n; j++) { //小球
            for (int i = 1; i < m; i++) { //行数
                if (dp[i - 1][j] == -1) {
                    dp[i][j] = -1;
                    continue;
                }
                int col = dp[i - 1][j]; //当前小球位置
                if (col == 0 && grid[i][col] == -1) {
                    dp[i][j] = -1;
                } else if (col == n - 1 && grid[i][col] == 1) {
                    dp[i][j] = -1;
                } else {
                    if (grid[i][col] == 1 && grid[i][col + 1] == 1) {
                        dp[i][j] = col + 1;
                    } else if (grid[i][col] == -1 && grid[i][col - 1] == -1) {
                        dp[i][j] = col - 1;
                    } else {
                        dp[i][j] = -1;
                    }
                }
            }
        }
        return dp[m - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[4][6];
        grid[0] = new int[]{1, 1, 1, 1, 1, 1};
        grid[1] = new int[]{-1, -1, -1, -1, -1, -1};
        grid[2] = new int[]{1, 1, 1, 1, 1, 1};
        grid[3] = new int[]{-1, -1, -1, -1, -1, -1};
        findBall(grid);
    }
}
