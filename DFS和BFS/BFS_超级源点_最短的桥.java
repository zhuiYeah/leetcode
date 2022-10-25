package DFS和BFS;

import java.util.ArrayDeque;
import java.util.Deque;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BFS_超级源点_最短的桥 {
    int[][] grid;
    int n;
    Deque<Point> queue = new ArrayDeque<Point>();

    public int shortestBridge(int[][] grid) {
        this.grid = grid;
        n = grid[0].length;
        var foundFirstGrid = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    foundFirstGrid = true;
                    dfs(i, j);
                    break;
                }
            }
            if (foundFirstGrid) break;
        }
        int distance = 0;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int x = queue.size();
            for (int i = 0; i < x; i++) {
                var cur = queue.poll();
                assert cur != null;
                for (int[] dir : dirs) {
                    var nextx = cur.x + dir[0];
                    var nexty = cur.y + dir[1];
                    if (nextx >= 0 && nexty >= 0 && nextx < n && nexty < n) {
                        if (grid[nextx][nexty] == 1) {
                            return distance;
                        } else if (grid[nextx][nexty] == 0) {
                            queue.add(new Point(nextx, nexty));
                            grid[nextx][nexty] = 2;
                        }
                    }
                }
            }
            distance++;
        }
        return -1;
    }

    public void dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= n || grid[i][j] != 1) return;
        grid[i][j] = 2;
        queue.add(new Point(i, j));
        dfs(i - 1, j);
        dfs(i, j - 1);
        dfs(i + 1, j);
        dfs(i, j + 1);
    }
}
