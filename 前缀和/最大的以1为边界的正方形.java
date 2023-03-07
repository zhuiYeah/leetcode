package 前缀和;

public class 最大的以1为边界的正方形 {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int x = Math.min(m, n);
        var rowG = new int[m][n + 1];//快速得到某一行元素a b 之间的差值
        var colG = new int[m + 1][n];//快速得到某一列元素a b 之间的差值
        for (int i = 0; i < rowG.length; i++)
            for (int j = 1; j < rowG[0].length; j++)
                rowG[i][j] = rowG[i][j - 1] + grid[i][j - 1];
        for (int j = 0; j < n; j++)
            for (int i = 1; i < m + 1; i++)
                colG[i][j] = colG[i - 1][j] + grid[i - 1][j];
        //于是现在元素(a,y1),(a,y2)之间的和为rowG[a,y2+1] - rowG[a,y1]
        // （x1，b），（x2，b）之间的和为 colG[x2+1,b] - colG[x1,b]
        for (int edge = x; edge >= 1; edge--) {
            //当确定了矩阵边长度edge的时候，矩阵的所有可能左上顶点已经被确定
            for (int i = 0; i <= m - edge; i++) {
                for (int j = 0; j <= n - edge; j++) {
                    //（i，j）       (i,j+edge-1)
                    // (i+edge-1,j) (i+edge-1,j+edge-1)
                    if (rowG[i][j + edge] - rowG[i][j] != edge) continue;
                    if (rowG[i + edge - 1][j + edge] - rowG[i + edge - 1][j] != edge) continue;
                    if (colG[i + edge][j] - colG[i][j] != edge) continue;
                    if (colG[i + edge][j + edge - 1] - colG[i][j + edge - 1] != edge) continue;
                    return edge * edge;
                }
            }
        }
        return 0;
    }
}
