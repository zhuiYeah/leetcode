package 链蒸蒸简单;

//312场周赛 特别简单
public class 沙漏的最大总和 {
    int[][] grid;
    int m;
    int n;

    public int maxSum(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        int max = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                max = Math.max(max, sum(i, j));
            }
        }
        return max;
    }

    public int sum(int i, int j) {
        return grid[i][j] + grid[i - 1][j] + grid[i + 1][j] + grid[i + 1][j + 1] + grid[i - 1][j - 1] + grid[i - 1][j + 1] + grid[i + 1][j - 1];
    }
}
