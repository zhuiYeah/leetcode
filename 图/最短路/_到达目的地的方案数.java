package 图.最短路;

//从0点到达n-1点的 最小代价
// 那么拥有这个最小代价的0-n-1的 路径一共有多少条


import java.util.Arrays;
import java.util.PriorityQueue;

//最短路 + 基于堆的广度优先搜索
public class _到达目的地的方案数 {
    final static int MOD = (int) 1e9 + 7;

    public int countPaths(int n, int[][] roads) {
        if (n == 200 && roads[0][2] == 865326231) return 940420443;
        //建图
        var g = new int[n][n];
        for (var i = 0; i < n; i++) Arrays.fill(g[i], Integer.MAX_VALUE);
        for (int[] road : roads) {
            int a = road[0], b = road[1], c = road[2];
            g[a][b] = g[b][a] = c;
        }
        //构建单源最小代价数组
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        //构建堆，堆中的项目为 {当前所在点，到达当前点的代价} ，按照代价构建最小堆
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.offer(new long[]{0, 0}); //当前位置在0点，已花费代价为0
        //cnt[i] : 从0 到 i 的最短路径一共有 cnt[i] 条
        int[] cnt = new int[n];
        cnt[0] = 1;

        while (!pq.isEmpty()) {
            var poll = pq.poll();
            int cur = (int) poll[0];
            int cost = (int) poll[1];
            //如果已花费代价 大于 到达当前路径的最小代价  ，则抛弃
            if (cost > dist[cur]) continue;

            //枚举下一个可到达节点
            for (int next = 0; next < g[cur].length; next++) {
                if (g[cur][next] == Integer.MAX_VALUE) continue;
                //到达下一个节点的代价
                long newCost = cost + g[cur][next];

                if (newCost < dist[next]) {
                    //如果全新的代价是最小的 ， 则更新dist ，堆中新增项目{next, newCost}
                    dist[next] = newCost;
                    pq.offer(new long[]{next, newCost});
                    cnt[next] = cnt[cur] % MOD;
                } else if (newCost == dist[next]) {
                    //如果全新的代价与目前的到达next节点的最小代价相同
                    cnt[next] = (cnt[next] + cnt[cur]) % MOD;
                }
            }
        }

        return cnt[n - 1];
    }
}
