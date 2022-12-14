package _周赛;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;


//离线询问  + 堆 +  基于堆的广度优先搜索

//权的递增有一种接力的感觉 ： 你不能干掉的grid[i][j] 由我来解决 ， 解决之后我便计入cnt之中 ，之后的更大权都可以用
class efede {
    private static final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length, n = grid[0].length;
        int k = queries.length;
        int cnt = 0;
        var id = new Integer[k];
        //id 绑定了queries的下标 ，id[0] = 0，绑定了queries[0]
        for (int i = 0; i < k; i++) id[i] = i;
        //将id按照queries的值进行排序，便于进行离线询问
        Arrays.sort(id, (a, b) -> queries[a] - queries[b]);

        var pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{grid[0][0], 0, 0});
        grid[0][0] = -1; //标记为已经访问过（已经加入堆，将来如果有比他大的权出现，他一定会被访问）
        int[] res = new int[k];
        for (int idd : id) {
            //整个询问过程中，权 会从小到大
            int quan = queries[idd];
            while (!pq.isEmpty() && quan > pq.peek()[0]) {
                var cur = pq.poll();
                cnt++;
                int x = cur[1], y = cur[2];
                for (int[] dir : dirs) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] != -1) {
                        pq.add(new int[]{grid[nx][ny], nx, ny});
                        grid[nx][ny] = -1; //标记为已访问过
                    }
                }
            }

            res[idd] = cnt;
        }
        return res;
    }
}


//普通深搜
//超时 17/20
public class _矩阵查询可获得的最大分数 {
    int m, n;
    int[][] g;
    int cnt;
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    boolean[][] vis = new boolean[][]{};

    public int[] maxPoints(int[][] grid, int[] queries) {
        m = grid.length;
        n = grid[0].length;
        g = grid;
        vis = new boolean[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                max = Math.max(max, g[i][j]);
        }
        var res = new int[queries.length];
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < queries.length; i++) {
            if (queries[i] > max) {
                res[i] = m * n;
                continue;
            }
            cnt = 0;
            initVis();
            if (map.containsKey(queries[i])) {
                res[i] = map.get(queries[i]);
                continue;
            }
            dfs(queries[i], 0, 0);
            res[i] = cnt;
            map.put(queries[i], res[i]);
        }
        return res;
    }

    private void initVis() {
        for (int i = 0; i < vis.length; i++) {
            Arrays.fill(vis[i], false);
        }
    }

    private void dfs(int quan, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || quan <= g[i][j] || vis[i][j]) return;
        cnt++;
        vis[i][j] = true;
        for (int[] dir : dirs) {
            int nx = i + dir[0];
            int ny = j + dir[1];
            dfs(quan, nx, ny);
        }
    }
}

