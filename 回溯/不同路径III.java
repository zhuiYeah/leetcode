package 回溯;

public class 不同路径III {
    int count;
    int m, n;
    int[][] grid;
    int all0;

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        int startRow = -1, startCol = -1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                } else if (grid[i][j] == 0) {
                    all0++;
                }
            }
        }
        backtracking(startRow + 1, startCol, 0);
        backtracking(startRow - 1, startCol, 0);
        backtracking(startRow, startCol + 1, 0);
        backtracking(startRow, startCol - 1, 0);
        return count;
    }

    public void backtracking(int i, int j, int step) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 1 || grid[i][j] == -1) return;
        //到达终点了,检测步数是否与0的个数相同
        if (grid[i][j] == 2) {
            if (step == all0) count++;
            return;
        }
        //标记为已走过
        grid[i][j] = 1;
        backtracking(i - 1, j, step + 1);
        backtracking(i + 1, j, step + 1);
        backtracking(i, j - 1, step + 1);
        backtracking(i, j + 1, step + 1);
        //经过该点的本条路径已经全部走完了，标记为未走过之后向上回溯
        grid[i][j] = 0;
    }
}
