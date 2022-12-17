package 图.最短路;


import java.util.Arrays;

//细分一个图，判断从0点出发权为max的话能到达的最大节点总数

//稠密图+最短路
public class _细分图中的可到达节点 {
    static int N = 3010, INF = 0x3f3f3f3f;
    static int[][] g = new int[N][N];
    //原点到i点的最短距离为dist[i]
    static int[] dist = new int[N];
    boolean[] vis = new boolean[N];

    public int reachableNodes(int[][] edges, int max, int n) {
        // 建图
        for (int i = 0; i < n; i++) Arrays.fill(g[i], INF);
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1], c = edge[2];
            g[a][b] = g[b][a] = c + 1;
        }
        // 朴素 Dijkstra
        Arrays.fill(dist, INF);
        dist[0] = 0;
        //dijstra算法,有几个节点就更新几次，每次更新找出 之前未使用过的 距离0点最近的节点t， 使用dist[t]来更新整个dist数组
        for (int i = 0; i < n; i++) {
            int t = -1;
            //从所有点中找到一个距离0点最近的且 未vis的 点t
            for (int j = 0; j < n; j++) {
                if (!vis[j] && (t == -1 || dist[j] < dist[t])) t = j;
            }
            vis[t] = true;
            for (int j = 0; j < n; j++) dist[j] = Math.min(dist[j], dist[t] + g[t][j]);
        }
        // 统计答案
        int ans = 0;
        //初始点
        for (int i = 0; i < n; i++) if (dist[i] <= max) ans++;
        //边上的点
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1], c = edge[2];
            int c1 = Math.max(0, max - dist[a]), c2 = Math.max(0, max - dist[b]);
            ans += Math.min(c, c1 + c2);
        }
        return ans;
    }
}
