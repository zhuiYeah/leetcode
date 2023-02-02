package 图.bfs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 有向图(存在环和平行边)中一共有n个点，两点之间的边有两种颜色：红色和蓝色
 * 你需要给出一个长度为n的数组ans，ans[i]：表示从0到i点的颜色交替的最短路程，不存在的话则为-1
 */


public class 颜色交替的最短路径 {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[][] g = new int[n][n];
        // 建图：g[i][j] 为 0 表示 i到j没有直接相连的路径  1表示红色  2表示蓝色  3表示红色蓝色都有
        for (int[] edge : redEdges) {
            int a = edge[0], b = edge[1];
            g[a][b]++;
        }
        for (int[] edge : blueEdges) {
            int a = edge[0], b = edge[1];
            g[a][b] += 2;
        }

        int[] res = new int[n];
        var visited = new HashSet<String>(); //bfs去重 避免死循环
        for (int i = 1; i < n; i++) {
            visited.clear();
            visited.add("0" + " " + "all");
            var queue = new ArrayDeque<int[]>(); //我当前在queue.peek()[0]点 , 我来自于 queue.peek()[1]颜色边
            //初始化queue
            for (int j = 1; j < n; j++) {
                if (g[0][j] == 1 || g[0][j] == 2) {
                    queue.add(new int[]{j, g[0][j]});
                    visited.add(String.valueOf(j) + " " + String.valueOf(g[0][j]));
                } else if (g[0][j] == 3) {
                    queue.add(new int[]{j, 1});
                    queue.add(new int[]{j, 2});
                    visited.add(String.valueOf(j) + " " + "1");
                    visited.add(String.valueOf(j) + " " + "2");
                }
            }
            int step = 0;
            while (!queue.isEmpty()) {
                step++;
                int num = queue.size();
                for (int j = 0; j < num; j++) {
                    var cur = queue.poll(); // 现在我位于 cur[0]点，以cur[1]颜色这样的状态到达该点
                    //找到终点
                    if (cur[0] == i) {
                        res[i] = step;
                        queue.clear();
                        break;
                    }
                    for (int k = 0; k < n; k++) {
                        //现在能从cur[0]到达k点嘛？
                        if (g[cur[0]][k] != 0 && cur[1] != g[cur[0]][k] && !visited.contains(k + " " + String.valueOf(3 - cur[1]))) {
                            queue.add(new int[]{k, 3 - cur[1]});
                            visited.add(k + " " + String.valueOf(3 - cur[1]));
                        }
                    }
                }
            }
            if (res[i] == 0) res[i] = -1;
        }

        return res;
    }
}

//优化: 以上经历了 n 次 bfs ，这里只使用两次bfs， 从红色出发 or 从蓝色出发
class fdrefre {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[][] g = new int[n][n];
        // 建图：g[i][j] 为 0 表示 i到j没有直接相连的路径  1表示红色  2表示蓝色  3表示红色蓝色都有
        for (int[] edge : redEdges) {
            int a = edge[0], b = edge[1];
            g[a][b]++;
        }
        for (int[] edge : blueEdges) {
            int a = edge[0], b = edge[1];
            g[a][b] += 2;
        }

        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        var visited = new HashSet<String>(); //bfs去重 避免死循环
        var queue = new ArrayDeque<int[]>(); //我当前在queue.peek()[0]点 , 我来自于 queue.peek()[1]颜色边
        //初始化从颜色1出发
        visited.add("0" + " " + "1"); //现在在 0 点 ， 从颜色1 路径而来，接下来只能走颜色2路径
        queue.add(new int[]{0, 1});

        int step = -1;
        while (!queue.isEmpty()) {
            step++;
            int num = queue.size();
            for (int j = 0; j < num; j++) {
                var cur = queue.poll(); // 现在我位于 cur[0]点，以cur[1]颜色这样的状态到达该点，经过了step长度的路程
                res[cur[0]] = Math.min(res[cur[0]], step);
                for (int k = 0; k < n; k++) {
                    //现在能从cur[0]到达k点嘛？
                    if (g[cur[0]][k] != 0 && cur[1] != g[cur[0]][k] && !visited.contains(k + " " + String.valueOf(3 - cur[1]))) {
                        queue.add(new int[]{k, 3 - cur[1]});
                        visited.add(k + " " + String.valueOf(3 - cur[1]));
                    }
                }
            }
        }
        //初始化从颜色2出发
        visited.clear();
        visited.add("0" + " " + "2"); //现在在 0 点 ， 从颜色1 路径而来，接下来只能走颜色2路径
        queue.add(new int[]{0, 2});
        step = -1;
        while (!queue.isEmpty()) {
            step++;
            int num = queue.size();
            for (int j = 0; j < num; j++) {
                var cur = queue.poll(); // 现在我位于 cur[0]点，以cur[1]颜色这样的状态到达该点，经过了step长度的路程
                res[cur[0]] = Math.min(res[cur[0]], step);
                for (int k = 0; k < n; k++) {
                    //现在能从cur[0]到达k点嘛？
                    if (g[cur[0]][k] != 0 && cur[1] != g[cur[0]][k] && !visited.contains(k + " " + String.valueOf(3 - cur[1]))) {
                        queue.add(new int[]{k, 3 - cur[1]});
                        visited.add(k + " " + String.valueOf(3 - cur[1]));
                    }
                }
            }
        }

        for (int i = 1; i < n; i++) if (res[i] == Integer.MAX_VALUE) res[i] = -1;
        return res;
    }
}