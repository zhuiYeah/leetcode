package DFS和BFS;

public class 图像渲染 {
    int color;
    int newColor;
    int m;
    int n;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        color = image[sr][sc];
        m = image.length;
        n = image[0].length;
        this.newColor = newColor;
        if (newColor == color){
            return image;
        }
        dfs(sr, sc, image);
        return image;
    }

    public void dfs(int row, int col, int[][] image) {
        if (row < 0 || col < 0 || row >= m || col >= n || image[row][col] != color) return;
        image[row][col] = newColor;
        dfs(row - 1, col, image);
        dfs(row + 1, col, image);
        dfs(row, col - 1, image);
        dfs(row, col + 1, image);
    }
}
