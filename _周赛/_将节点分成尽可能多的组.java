package _周赛;

//相连的节点必须属于相邻组，节点最多能分成多少组

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

//枚举集群所有节点进行bfs + 判断二分图
public class _将节点分成尽可能多的组 {
    List<Integer>[] g;
    ArrayList<Integer> node = new ArrayList<Integer>();//会记录一个集群的所有节点
    int[] color; //用于isBipartite
    int base;//每个集群的第一个分组标记为group base
    int clock;//由于要对一个集群进行多次bfs，那么标记为第clock次bfs
    int[] time;//用于bfs，time[x] = clock即中止bfs

    public int magnificentSets(int n, int[][] edges) {
        g = new ArrayList[n];
        for (int i = 0; i < g.length; i++) g[i] = new ArrayList<>();
        //建图
        for (int[] edge : edges) {
            int a = edge[0] - 1, b = edge[1] - 1;
            g[a].add(b);
            g[b].add(a);
        }
        color = new int[n];
        time = new int[n];
        var res = 0;
        for (int i = 0; i < n; i++) {
            if (color[i] != 0) continue;
            node.clear();
            if (!isBipartite(i, 1)) return -1;//不是二分图，无法分组
            base = res + 1;
            //枚举起点bfs
            for (int x : node)
                res = Math.max(res, bfs(x));
        }

        return res;
    }

    //判断当前节点所在集群是不是二分图 ，且顺便完成染色 ,同时将当前集群的全部点记录进入node
    private boolean isBipartite(int curNode, int c) {
        if (color[curNode] == c) return true;
        if (color[curNode] == -c) return false;
        node.add(curNode);
        color[curNode] = c;
        for (int nxt : g[curNode]) if (!isBipartite(nxt, -c)) return false;
        return true;
    }

    //以start作为起点，能将所在集群分成XX个group ，bfs
    private int bfs(int start) {
        int max = 0;
        time[start] = ++clock;
        var queue = new ArrayDeque<int[]>();
        queue.add(new int[]{start, base});//start节点在group base
        while (!queue.isEmpty()) {
            var cur = queue.poll();
            int x = cur[0], groupId = cur[1];
            max = Math.max(max, groupId);
            for (int y : g[x]) {
                if (time[y] == clock) continue;
                time[y] = clock;
                queue.add(new int[]{y, groupId + 1});
            }
        }
        return max;
    }
}
