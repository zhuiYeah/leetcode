package 周赛;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//123/131
//超时了 ，也是尽力了
public class _好路径的数目 {
    int count = 0;
    int[] vals;
    //映射出发点和所有目的点
    Map<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
    int n;

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        this.vals = vals;
        n = vals.length;

        int res = n;

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            var l1 = map.getOrDefault(a, new HashSet<Integer>());
            l1.add(b);
            map.put(a, l1);
            var l2 = map.getOrDefault(b, new HashSet<Integer>());
            l2.add(a);
            map.put(b, l2);
        }
        var xx = new HashMap<Integer, Integer>();
        var x = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            xx.put(vals[i], xx.getOrDefault(vals[i], 0) + 1);
            if (xx.get(vals[i]) > 1) x.add(vals[i]);
        }
        for (int i = 0; i < n; i++) {
            if (x.contains(vals[i])) {
                dfs(i, -1, i);
            }
        }
        return res + count / 2;
    }

    //当前节点来自from，当前路径的根路径为root
    public void dfs(int curNode, int from, int root) {
        if (vals[curNode] > vals[root]) return;
        if (vals[curNode] == vals[root] && root != curNode) {
            count++;
        }
        var choose = map.getOrDefault(curNode, new HashSet<Integer>());
        for (int next : choose) {
            if (next != from && vals[next] <= vals[root] && next != curNode) {
                dfs(next, curNode, root);
            }
        }
    }
}
