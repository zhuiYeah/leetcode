package _周赛;

import java.util.ArrayList;
import java.util.List;

public class 图中最大星和 {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        List<Integer>[] g;
        int n = vals.length;
        g = new ArrayList[n];
        for (int i = 0; i < g.length; i++) g[i] = new ArrayList<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            g[a].add(b);
            g[b].add(a);
        }
        //每个点能到达的下一个点从大到小排序
        for (int i = 0; i < n; i++) {
            g[i].sort((a, b) -> {
                return vals[b] - vals[a];
            });
        }
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < g.length; i++) {
            int sum = vals[i];
            for (int j = 0; j < Math.min(g[i].size(), k) && vals[g[i].get(j)] > 0; j++)
                sum += vals[g[i].get(j)];
            max = Math.max(max, sum);
        }

        return max;
    }
}
