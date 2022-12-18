package 图;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

///有一个无向图，有n个节点 1～n ，现在至多添加两条边（不能出现重复边 和 自环点） ，让整个图的全部节点 度 为偶数 ，能做到吗？

//情况要考虑全  jiList.size() == 2 的情况考虑的不周全 wa一次

//超出内存限制 wa 2次
public class 添加边使所有节点度数都为偶数 {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        //g就是图
        List<Integer>[] g = new List[n + 1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();
        //g记录两点直接是否有直接路径
        boolean[][] gg = new boolean[n + 1][n + 1];
        for (List<Integer> edge : edges) {
            int a = edge.get(0), b = edge.get(1);
            g[a].add(b);
            g[b].add(a);
            gg[a][b] = gg[b][a] = true;
        }
        int[] du = new int[n + 1];
        //记录所有度为奇数的节点
        var jiList = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            du[i] = g[i].size();
            if (du[i] % 2 == 1) jiList.add(i);
        }

        if (jiList.size() > 4) return false;
        if (jiList.size() == 0) return true;
        if (jiList.size() == 3) System.out.println("这是不可能的");
        if (jiList.size() == 2) {
            int a = jiList.get(0), b = jiList.get(1);
            if (!gg[a][b]) return true;
            for (int i = 1; i <= n; i++) {
                if (i == a || i == b) continue;
                if (!gg[a][i] && gg[b][i]) return true;
            }
            return false;
        }
        if (jiList.size() == 4) {
            int a = jiList.get(0), b = jiList.get(1), c = jiList.get(2), d = jiList.get(3);
            if (!gg[a][b] && !gg[c][d]) return true;
            if (!gg[a][c] && !gg[b][d]) return true;
            if (!gg[a][d] && !gg[b][c]) return true;
        }
        return false;
    }
}

//用hashset替代二维数组10^5，解决内存超出限制的问题
class feferw {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        //g记录一个图的度
        Set<Integer>[] g = new HashSet[n + 1];
        for (int i = 1; i <= n; i++) g[i] = new HashSet<>();
        //gg记录两点直接是否有直接路径
        for (List<Integer> edge : edges) {
            int a = edge.get(0), b = edge.get(1);
            g[a].add(b);
            g[b].add(a);
        }
        int[] du = new int[n + 1];
        //记录所有度为奇数的节点
        var jiList = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            du[i] = g[i].size();
            if (du[i] % 2 == 1) jiList.add(i);
        }

        if (jiList.size() > 4) return false;
        if (jiList.size() == 0) return true;
        if (jiList.size() == 3) System.out.println("这是不可能的");
        if (jiList.size() == 2) {
            int a = jiList.get(0), b = jiList.get(1);
            if (!g[a].contains(b)) return true;
            for (int i = 1; i <= n; i++) {
                if (i == a || i == b) continue;
                if (!g[a].contains(i) && !g[b].contains(i)) return true;
            }
            return false;
        }
        if (jiList.size() == 4) {
            int a = jiList.get(0), b = jiList.get(1), c = jiList.get(2), d = jiList.get(3);
            if (!g[a].contains(b) && !g[c].contains(d)) return true;
            if (!g[a].contains(c) && !g[b].contains(d)) return true;
            if (!g[a].contains(d) && !g[b].contains(c)) return true;
        }
        return false;
    }
}
