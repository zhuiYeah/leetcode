package _周赛;

import java.util.HashSet;
import java.util.Set;

/**
 * 周赛T4
 * 有一个 m * n的矩阵 ， 值仅为 0 ，1
 * <p>
 * 最多翻转一次矩阵中的点  1  -》 0
 * <p>
 * 如果可以使得 (0，0) - > (m-1,n-1) 不存在连通路径 ， 返回true，否则返回 false
 */

public class ___二进制矩阵中翻转最多一次使路径不连通 {
    int m, n;
    Set<Integer> connect = new HashSet<Integer>();
    int[][] g;

    public boolean isPossibleToCutPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        g = grid;
        dfs(0, 0);
        if (!connect.contains(m * n - 1)) return true;
        connect.remove(0);
        connect.remove(m * n - 1);
        for (int x : connect) {
            int row = x / n, col = x % n;
            grid[row][col] = 0;
            if (!dfs2(0, 0)) return true;
            grid[row][col] = 1;
        }
        return false;
    }

    private void dfs(int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n || g[row][col] == 0) return;
        if (connect.contains(row * n + col)) return;
        connect.add(row * n + col);
        dfs(row, col + 1);
        dfs(row - 1, col);
        dfs(row + 1, col);
        dfs(row, col - 1);
    }

    private boolean dfs2(int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n || g[row][col] == 0 || g[row][col] == -1) return false;
        if (row == m - 1 && col == n - 1) return true;
        var tmp = g[row][col];
        g[row][col] = -1;
        if (dfs2(row, col + 1)) {
            g[row][col] = tmp;
            return true;
        }
        if (dfs2(row, col - 1)) {
            g[row][col] = tmp;
            return true;
        }
        if (dfs2(row + 1, col)) {
            g[row][col] = tmp;
            return true;
        }
        if (dfs2(row - 1, col)) {
            g[row][col] = tmp;
            return true;
        }
        g[row][col] = tmp;
        return false;
    }

}

class dfrefderw {
    public static void main(String[] args) {
        var grid = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        new ___二进制矩阵中翻转最多一次使路径不连通().isPossibleToCutPath(grid);
    }
}


class testHashSet {
    public static void main(String[] args)  {
        var x = new int[] {1,2,3};
        var y = new int[] {1,2,3};
        var set = new HashSet<int[]>();
        set.add(x);
        set.add(y);
        System.out.println(set.size());
    }
}
