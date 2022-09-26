package DFS和BFS;

import java.util.ArrayDeque;

public class bfs二进制矩阵中的最短路径 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        var queue = new ArrayDeque<int[]>();
        queue.add(new int[]{0, 0});
        grid[0][0] = 1;
        int step = 1;
        int[][] dirs = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        while (!queue.isEmpty()) {
            //表示第step步能达到的点有x个
            int x = queue.size();
            for (int i = 0; i < x; i++) {
                var cur = queue.poll();
                assert cur != null;
                int row = cur[0], col = cur[1];
                if (row == n - 1 && col == n - 1) return step;
                for (int k = 0; k < 8; k++) {
                    int nextRow = row + dirs[k][0], nextCol = col + dirs[k][1];
                    if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < n && grid[nextRow][nextCol] == 0) {
                        queue.add(new int[]{nextRow, nextCol});
                        grid[nextRow][nextCol] = 1;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
