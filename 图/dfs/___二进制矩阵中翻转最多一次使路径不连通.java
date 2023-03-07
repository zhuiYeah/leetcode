package 图.dfs;

import java.util.HashSet;
import java.util.Set;

/**
 * 周赛T4
 * 有一个 m * n的矩阵 ， 值仅为 0 ，1
 * <p>
 * 最多翻转一次矩阵中的点  1  -》 0
 * <p>
 * 如果可以使得 (0，0) - > (m-1,n-1) 不存在连通路径 ， 返回true，否则返回 false
 *
 * 连通路径只能向下或者向右走
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
    public static void main(String[] args) {
        var x = new int[]{1, 2, 3};
        var y = new int[]{1, 2, 3};
        var set = new HashSet<int[]>();
        set.add(x);
        set.add(y);
        System.out.println(set.size());
    }
}


class dfewferw {
    private int[][] g;
    private int m, n;

    public boolean isPossibleToCutPath(int[][] grid) {
        g = grid;
        m = g.length;
        n = g[0].length;
        //第一次找下轮廓，并且标记访问过 ， 第二次走上轮廓
        //第一次不能连通 ｜｜ 第一次连通第二次不能连通
        return !dfs(0, 0, true) || !dfs(0, 0, false);

    }

    //能否从x，y位置走到终点
    private boolean dfs(int x, int y, boolean first) {
        if (x < 0 || x >= m || y < 0 || y >= n || g[x][y] == 0) return false;
        if (x == m - 1 && y == n - 1) return true;
        if (!(x == 0 && y == 0)) g[x][y] = 0;
        if (first)  //先下再右，寻找下轮廓
            return dfs(x + 1, y, true) || dfs(x, y + 1, true);
        else       //先右再下，寻找上轮廓
            return dfs(x, y + 1, false) || dfs(x + 1, y, false);
    }
}