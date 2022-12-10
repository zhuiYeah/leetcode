package 图;

//染色法 + dfs

import java.util.ArrayList;
import java.util.List;

//判断一个无向图是不是二分图 ， 即图中的相邻节点必须异色（共两种颜色）
public class _判断二分图 {
    List<Integer>[] g;//图
    int[] color;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        g = new ArrayList[n];
        for (int i = 0; i < g.length; i++) g[i] = new ArrayList<>();
        color = new int[n]; //初始0表示全部未染色
        //建图
        for (int i = 0; i < n; i++)
            for (int nxt : graph[i])
                g[i].add(nxt);


        //开始染色
        for (int i = 0; i < n; i++) {
            if (color[i] != 0) continue;
            if (!canChange(i, 1)) return false;
        }

        return true;
    }

    //当前节点能染成c吗？ 当然这会递归到当前节点所在集群的每一个节点 dfs
    private boolean canChange(int curNode, int c) {
        if (color[curNode] == -c) return false;
        if (color[curNode] == c) return true;
        color[curNode] = c;
        for (Integer nxt : g[curNode]) if (!canChange(nxt, -c)) return false;

        return true;
    }
}
