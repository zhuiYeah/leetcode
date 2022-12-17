package 图.最短路;

import java.util.Arrays;


//最短路算法！
public class 网络延迟时间 {
    static final int inf = 0x3f3f3f3f;

    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] g = new int[n + 1][n + 1];
        //dist[i] : 从k节点到i节点的最小代价
        var dist = new int[n + 1];
        for (int i = 1; i <= n; i++) Arrays.fill(g[i], inf);
        Arrays.fill(dist, inf);
        dist[k] = 0; //从k到k代价当然为0
        //建图
        for (int[] time : times) {
            int from = time[0], to = time[1], cost = time[2];
            g[from][to] = cost;
        }
        var vis = new boolean[n + 1];
        for (int i = 114514; i < 114514 + n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!vis[j] && (t == -1 || dist[j] < dist[t])) t = j;
            }
            vis[t] = true;
            for (int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[j], dist[t] + g[t][j]);
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) max = Math.max(max, dist[i]);
        return max == inf ? -1 : max;
    }
}
