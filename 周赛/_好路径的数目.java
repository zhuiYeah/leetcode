package 周赛;

import java.util.*;
import java.util.stream.IntStream;


//312场周赛
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

/////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////

class dwewdw {
    int[] fa;

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        //共有n个节点
        var n = vals.length;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        // 建图 g
        for (var e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x);
        }

        //集群
        fa = new int[n];
        for (var i = 0; i < n; i++) fa[i] = i;
        // size[x] 表示节点值等于 vals[x] 的节点个数，如果按照节点值从小到大合并，size[x] 也是连通块内的等于最大节点值的节点个数
        var size = new int[n];
        Arrays.fill(size, 1);
        var id = IntStream.range(0, n).boxed().toArray(Integer[]::new);
        //从小到大给节点做排序 值小的节点在前
        Arrays.sort(id, (i, j) -> vals[i] - vals[j]);

        var ans = n;
        for (var x : id) {
            //vx是该节点的值 ， fx是该节点所在集群的代表节点
            int vx = vals[x], fx = find(x);
            //遍历图中的所有节点
            for (var y : g[x]) {
                y = find(y);
                if (y == fx || vals[y] > vx) continue; // 只考虑最大节点值比 vx 小的连通块
                if (vals[y] == vx) { // 可以构成好路径
                    ans += size[fx] * size[y]; // 乘法原理
                    size[fx] += size[y]; // 统计连通块内节点值等于 vx 的节点个数
                }
                fa[y] = fx; // 把小的节点值合并到大的节点值上
            }
        }
        return ans;
    }

    int find(int x) {
        if (fa[x] != x) fa[x] = find(fa[x]);
        return fa[x];
    }


}