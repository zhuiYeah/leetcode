package DFS和BFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class dfs最大人工岛 {
    int[][] grid;
    int n;
    int islandNum;
    int max;
    List<Integer> islandArea = new ArrayList<Integer>();

    public int largestIsland(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        islandNum = 1;
        //岛屿0和岛屿1是不存在的，0和1不能用来标记岛屿
        //0标记的是水域，第一轮循环结束后，不存在1标记
        islandArea.add(0);
        islandArea.add(0);
        max = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //出现新的岛屿了，为这个岛屿更新专属他的islandNum
                if (grid[i][j] == 1) {
                    islandNum++;
                    int area = dfs(i, j);
                    max = Math.max(area, max);
                    islandArea.add(area);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //遇到可以去填充的水域了
                if (grid[i][j] == 0) {
                    max = Math.max(max, filling(i, j));
                }
            }
        }
        return max;
    }

    public int dfs(int row, int col) {
        if (row < 0 || col < 0 || row >= n || col >= n || grid[row][col] != 1) {
            return 0;
        }
        grid[row][col] = islandNum;
        return dfs(row + 1, col) + dfs(row - 1, col) + dfs(row, col - 1) + dfs(row, col + 1) + 1;
    }

    //人工填充一个空格后所能获得的面积
    public int filling(int row, int col) {
        //会获得相邻的岛屿号
        Set<Integer> set = new HashSet<Integer>();
        if (row - 1 >= 0) {
            set.add(grid[row - 1][col]);
        }
        if (row + 1 < n) {
            set.add(grid[row + 1][col]);
        }
        if (col - 1 >= 0) {
            set.add(grid[row][col - 1]);
        }
        if (col + 1 < n) {
            set.add(grid[row][col + 1]);
        }
        int area = 1;
        for (int i : set) {
            area += islandArea.get(i);
        }
        return area;
    }
}
