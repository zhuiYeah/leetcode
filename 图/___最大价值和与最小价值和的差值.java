package 图;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//周赛没写出来 超时
public class ___最大价值和与最小价值和的差值 {
    List<Integer>[] g;//图
    long res = 0;
    int[] price;
    Set<Integer> visit;

    public long maxOutput(int n, int[][] edges, int[] price) {
        this.price = price;
        g = new ArrayList[n];
        for (int i = 0; i < g.length; i++) g[i] = new ArrayList<>();
        //度为1的点一定是某个起点或者某个终点
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            g[a].add(b);
            g[b].add(a);
        }
        visit = new HashSet<>();
        var list = new ArrayList<Integer>();//记录所有度为1的点
        for (int i = 0; i < g.length; i++) if (g[i].size() == 1) list.add(i);
        for (int i = 0; i < list.size(); i++) {
            visit.clear();
            dfs(list.get(i), 0);
        }
        return res;
    }

    private void dfs(int cur, int score) {
        visit.add(cur);
        res = Math.max(score, res);
        for (int nxt : g[cur]) {
            if (visit.contains(nxt)) continue;
            dfs(nxt, score + price[nxt]);
        }
    }
}

class Solution1 {
    List<Integer>[] g;//图
    long res = 0;
    int[] price;

    public long maxOutput(int n, int[][] edges, int[] price) {
        this.price = price;
        g = new ArrayList[n];
        for (int i = 0; i < g.length; i++) g[i] = new ArrayList<>();
        //度为1的点一定是某个起点或者某个终点
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            g[a].add(b);
            g[b].add(a);
        }
        var list = new ArrayList<Integer>();//记录所有度为1的点
        for (int i = 0; i < g.length; i++) if (g[i].size() == 1) list.add(i);
        for (int i = 0; i < list.size(); i++) {
            dfs(list.get(i), -1, 0);
        }
        return res;
    }

    private void dfs(int cur, int from, int score) {
        res = Math.max(score, res);
        for (int nxt : g[cur]) {
            if (nxt == from) continue;
            dfs(nxt, cur, score + price[nxt]);
        }
    }
}
