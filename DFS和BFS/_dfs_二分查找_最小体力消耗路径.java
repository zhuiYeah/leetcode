package DFS和BFS;

import java.util.*;


//写的没错，但超时 ;回溯超时了
//优化后仍超时
public class _dfs_二分查找_最小体力消耗路径 {
    int[][] heights;
    int m;
    int n;
    int curMinPay = 0;

    public int minimumEffortPath(int[][] heights) {
        this.heights = heights;
        m = heights.length;
        n = heights[0].length;
        for (int j = 1; j < n; j++) {
            curMinPay = Math.max(curMinPay, Math.abs(heights[0][j] - heights[0][j - 1]));
        }
        for (int i = 1; i < m; i++) {
            curMinPay = Math.max(curMinPay, Math.abs(heights[i][n - 1] - heights[i - 1][n - 1]));
        }
        dfs(0, 0, 0);
        return curMinPay;
    }

    public void dfs(int i, int j, int diff) {

        if (i == m - 1 && j == n - 1) {//叶子节点
            if (diff < curMinPay) {
                curMinPay = diff;
                return;
            }
        }
        if (diff > curMinPay) { //减枝
            return;
        }
        int tmp = heights[i][j];
        heights[i][j] = -1;
        if (i - 1 >= 0 && heights[i - 1][j] != -1) {
            int xxx = Math.max(diff, Math.abs(heights[i - 1][j] - tmp)); //如果往上走的话，需要的消耗为xxx
            if (xxx <= curMinPay) dfs(i - 1, j, xxx); //当这个消耗小于当前已找到路径的最小消耗时，才有必要去试一试这条路径
        }
        if (i + 1 < m && heights[i + 1][j] != -1) {
            int xxx = Math.max(Math.abs(heights[i + 1][j] - tmp), diff);
            if (xxx <= curMinPay) dfs(i + 1, j, xxx);
        }
        if (j - 1 >= 0 && heights[i][j - 1] != -1) {
            int xxx = Math.max(Math.abs(heights[i][j - 1] - tmp), diff);
            if (xxx <= curMinPay) dfs(i, j - 1, xxx);
        }
        if (j + 1 < n && heights[i][j + 1] != -1) {
            int xxx = Math.max(Math.abs(heights[i][j + 1] - tmp), diff);
            if (xxx <= curMinPay) dfs(i, j + 1, xxx);
        }
        //上下左右都没路了，本层递归即将结束，那么该点的已走过过标记应该取消
        heights[i][j] = tmp;

    }

    public void main(String[] args) {
        int[][] grid = new int[1][8];
        grid[0] = new int[]{1, 10, 6, 7, 9, 10, 4, 9};

        int x = minimumEffortPath(grid);
        System.out.println(x);
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//二分查找 0~1000000中的最小边权
// 超时，优化了二维数组的深复制之后还是超时
class Solution {
    int[][] heights;
    int m;
    int n;

    public int minimumEffortPath(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        this.heights = new int[m][n];
        int left = 0, right = 999999;
        int res = 0;
        while (left <= right) {
            for (int i = 0; i < m; i++) {
                this.heights[i] = heights[i].clone();
            }
            int mid = left + (right - left) / 2;
            if (dfs(0, 0, mid)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;

    }

    public boolean dfs(int i, int j, int diff) {
        if (i == m - 1 && j == n - 1) {
            return true;
        }
        int tmp = heights[i][j];
        heights[i][j] = -1;
        if (i - 1 >= 0 && heights[i - 1][j] != -1) {
            int xxx = Math.abs(heights[i - 1][j] - tmp);
            if (xxx <= diff) {
                if (dfs(i - 1, j, diff)) return true;
            }
        }
        if (i + 1 < m && heights[i + 1][j] != -1) {
            int xxx = Math.abs(heights[i + 1][j] - tmp);
            if (xxx <= diff) {
                if (dfs(i + 1, j, diff)) return true;
            }
        }
        if (j - 1 >= 0 && heights[i][j - 1] != -1) {
            int xxx = Math.abs(heights[i][j - 1] - tmp);
            if (xxx <= diff) {
                if (dfs(i, j - 1, diff)) return true;
            }
        }
        if (j + 1 < n && heights[i][j + 1] != -1) {
            int xxx = Math.abs(heights[i][j + 1] - tmp);
            if (xxx <= diff) {
                if (dfs(i, j + 1, diff)) return true;
            }
        }
        heights[i][j] = tmp;
        return false;
    }

}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//使用广度优先搜索 + 二分查找；
class Solution1 {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int left = 0, right = 999999, res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            Queue<int[]> queue = new ArrayDeque<>(); //储存点
            queue.offer(new int[]{0, 0});
            boolean[][] seen = new boolean[m][n];
            seen[0][0] = true;
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int row = cur[0];
                int col = cur[1];
                for (int i = 0; i < 4; i++) {
                    int nextRow = row + dirs[i][0];
                    int nextCol = col + dirs[i][1];
                    if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n && !seen[nextRow][nextCol] && Math.abs(heights[row][col] - heights[nextRow][nextCol]) <= mid) {
                        seen[nextRow][nextCol] = true;
                        queue.offer(new int[]{nextRow, nextCol});
                    }
                }
            }
            if (seen[m - 1][n - 1]) { //权mid足够可以走到重点，可能有更小的走到终点权
                res = mid;
                right = mid - 1;
            } else { //权mid不足以走到重点，需要增大权
                left = mid + 1;
            }
        }
        return res;
    }


}




