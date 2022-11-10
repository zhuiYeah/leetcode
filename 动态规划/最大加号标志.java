package 动态规划;

//这数据量不来个暴力？ 虽说是动态规划，但是四个二维数组来记录每个点上下左右距离0的最小距离写着很烦，这数据量直接暴力吧。
public class 最大加号标志 {
    int[][] grid;
    int max = 0;
    int n;

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        this.n = n;
        grid = new int[n][n];
        for (int[] mine : mines) grid[mine[0]][mine[1]] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) count(i, j);
            }
        }
        return max;
    }

    public void count(int row, int col) {
        int maybemax = Math.min(row + 1, Math.min(n - row, Math.min(col + 1, n - col)));
        if (maybemax <= max) return;
        int up = 0, down = 0, left = 0, right = 0;
        for (int i = row; i >= 0 && grid[i][col] != 1; i--) up++;
        if (up <= max) return;
        for (int i = row; i < n && grid[i][col] != 1; i++) down++;
        if (down <= max) return;
        for (int j = col; j >= 0 && grid[row][j] != 1; j--) left++;
        if (left <= max) return;
        for (int j = col; j < n && grid[row][j] != 1; j++) right++;
        if (right <= max) return;
        max = Math.max(max, Math.min(up, Math.min(down, Math.min(left, right))));
    }
}
