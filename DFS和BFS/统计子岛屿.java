package DFS和BFS;

public class 统计子岛屿 {
    int[][] grid1;
    int[][] grid2;
    int m;
    int n;
    int res;
    boolean isContain;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        this.grid1 = grid1;
        this.grid2 = grid2;
        this.m = grid1.length;
        this.n = grid1[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    isContain = true;
                    dfs(i, j);
                    if (isContain) res++;
                }
            }
        }
        return res;
    }
    public void dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid2[i][j] != 1) return;
        grid2[i][j] = 3;
        if (grid1[i][j] == 0) isContain = false;
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j - 1);
        dfs(i, j + 1);
    }
}
