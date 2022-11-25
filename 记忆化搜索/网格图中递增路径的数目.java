package 记忆化搜索;

public class 网格图中递增路径的数目 {
    final int MOD = (int) 1e9 + 7;
    int m, n;
    long[][] f;//以 m n 为终点的 单调递增路径的数数目
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] grid;

    public int countPaths(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        f = new long[m][n];
        long sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum = (sum + f(i, j)) % MOD;
            }
        }
        return (int) sum;
    }

    private long f(int row, int col) {
        if (f[row][col] != 0) return f[row][col];
        f[row][col] = 1;
        for (int[] dir : dirs) {
            int i = row + dir[0], j = col + dir[1];
            if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] >= grid[row][col]) continue;
            f[row][col] = (f[row][col] + f(i, j)) % MOD;
        }
        return f[row][col];
    }
}
