package 链蒸蒸简单;

public class 判断矩阵是否是一个X矩阵 {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            if (grid[i][i] == 0) return false;
            grid[i][i] = -1;
            if (grid[i][n - 1 - i] == 0) return false;
            grid[i][n - 1 - i] = -1;
        }
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                if (ints[j] == -1) continue;
                if (ints[j] != 0) return false;
            }
        }
        return true;
    }
}
