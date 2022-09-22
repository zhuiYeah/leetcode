package 数组;

public class 矩阵中的局部最大值 {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                res[i][j] = countMax(grid, i, j);
            }
        }
        return res;
    }

    public int countMax(int[][] grid, int row, int col) {
        int max = grid[row][col];
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }
        return max;
    }
}
