package DFS和BFS.bfs;

import java.util.ArrayDeque;
import java.util.HashSet;

/**
 * hard : 2022
 * 在一个n * n的矩阵中
 * 贪吃蛇的身体占两格，可以水平，可以垂直，
 * 贪吃蛇只能存在于 矩阵中值为0的格子中
 * 贪吃蛇每一步可以向右走，向下走，旋转
 * 贪吃蛇的初始位置在(0,0) (0,1) ,终点在  (n-1,n-2) (n-1,n-1)
 * 给出贪吃蛇到达终点的最短步数
 *
 * */

public class 穿过迷宫的最少移动次数 {
    public int minimumMoves(int[][] grid) {
        int n = grid.length, step = -1;
        var visited = new HashSet<String>();
        visited.add(0 + "," + 0 + " " + 0 + "," + 1);
        var queue = new ArrayDeque<int[]>();
        queue.add(new int[]{0, 0, 0, 1});
        while (!queue.isEmpty()) {
            int x = queue.size();
            step++;
            for (int xx = 0; xx < x; xx++) {
                var cur = queue.poll();
                assert cur != null;
                int x1 = cur[0], y1 = cur[1], x2 = cur[2], y2 = cur[3];
                if (x1 == n - 1 && x2 == n - 1 && y1 == n - 2 && y2 == n - 1) return step;

                if (x1 == x2) {//如果水平 x1 == x2 , y2 - y1 == 1
                    //向右走
                    if (y2 + 1 < n && grid[x1][y2 + 1] == 0 && !visited.contains(x2 + "," + y2 + " " + x2 + "," + y2 + 1)) {
                        visited.add(x2 + "," + y2 + " " + x2 + "," + y2 + 1);
                        queue.add(new int[]{x2, y2, x2, y2 + 1});
                    }
                    //旋转
                    if (x1 + 1 < n && grid[x1 + 1][y1] == 0 && grid[x1 + 1][y2] == 0 && !visited.contains(x1 + "," + y1 + " " + x1 + 1 + "," + y1)) {
                        visited.add(x1 + "," + y1 + " " + x1 + 1 + "," + y1);
                        queue.add(new int[]{x1, y1, x1 + 1, y1});
                    }
                    //向下走
                    if (x1 + 1 < n && grid[x1 + 1][y1] == 0 && grid[x2 + 1][y2] == 0 && !visited.contains(x1 + 1 + "," + y1 + " " + x2 + 1 + "," + y2)) {
                        visited.add(x1 + 1 + "," + y1 + " " + x2 + 1 + "," + y2);
                        queue.add(new int[]{x1 + 1, y1, x2 + 1, y2});
                    }
                } else {//如果垂直 ,y1 == y2 , x2 - x1 == 1
                    //向下走
                    if (x2 + 1 < n && grid[x2 + 1][y1] == 0 && !visited.contains(x2 + "," + y2 + " " + x2 + 1 + "," + y2)) {
                        visited.add(x2 + "," + y2 + " " + x2 + 1 + "," + y2);
                        queue.add(new int[]{x2, y2, x2 + 1, y2});
                    }
                    //旋转
                    if (y1 + 1 < n && grid[x1][y1 + 1] == 0 && grid[x2][y1 + 1] == 0 && !visited.contains(x1 + "," + y1 + " " + x1 + "," + y1 + 1)) {
                        visited.add(x1 + "," + y1 + " " + x1 + "," + y1 + 1);
                        queue.add(new int[]{x1, y1, x1, y1 + 1});
                    }
                    //向右走
                    if (y1 + 1 < n && grid[x1][y1 + 1] == 0 && grid[x2][y2 + 1] == 0 && !visited.contains(x1 + "," + y1 + 1 + " " + x2 + "," + y2 + 1)) {
                        visited.add(x1 + "," + y1 + 1 + " " + x2 + "," + y2 + 1);
                        queue.add(new int[]{x1, y1 + 1, x2, y2 + 1});
                    }
                }
            }
        }
        return -1;
    }
}

class testHashSet {
    public static void main(String[] args) {
        var x = new int[]{1, 2, 3};
        var y = new int[]{1, 2, 3};
        var set = new HashSet<int[]>();
        set.add(x);
        set.add(y);
        System.out.println(set.size());
    }
}
