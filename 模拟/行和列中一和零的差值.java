package 模拟;

public class 行和列中一和零的差值 {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] zeroRow = new int[m];
        int[] zeroCol = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    zeroRow[i]++;
                    zeroCol[j]++;
                }
            }
        }
        int[][] diff = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diff[i][j] = n - 2 * zeroRow[i] + m - 2 * zeroCol[j];
            }
        }
        return diff;
    }
}
