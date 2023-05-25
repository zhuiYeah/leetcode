package 图.bfs;

import java.util.ArrayList;

/**
 * 给出一个树（n个点），青蛙一秒跳一次，初始位置在1，求T秒后青蛙的在target点（1～n）的概率。
 */

public class T秒后青蛙的位置 {
    int T;
    ArrayList<Integer>[] g;
    int TARGET;
    double res = 0.0;

    public double frogPosition(int n, int[][] edges, int t, int target) {
        g = new ArrayList[n];
        T = t;
        TARGET = target - 1;
        for (int i = 0; i < n; i++) g[i] = new ArrayList<Integer>();
        for (int[] edge : edges) {
            int a = edge[0] - 1, b = edge[1] - 1;
            g[a].add(b);
            g[b].add(a);
        }
        if (TARGET == 0) {
            if (g[0].size() == 0) return 1.0;
            else return 0.0;
        }

        for (int nxt : g[0])
            dfs(nxt, 0, 1, g[0].size());
        return res;
    }

    private void dfs(int cur, int from, int step, int fork) {

        //时间为T
        if (step == T) {
            if (cur == TARGET) res += 1.0 / fork;
            return;
        }
        //如果到了叶子节点并且叶子节点不是目标节点，那么这条路径就失去了意义
        //如果到了叶子节点并且叶子节点是目标节点，那么目前的概率 * 100%  在时间t到达TARGET点
        if (g[cur].size() == 1) {
            if (cur == TARGET) res += 1.0 / fork;
            return;
        }
        //不是叶子节点，时间不为T，但命中了，那么T时间一定不可能命中
        if (cur == TARGET) return;
        for (int nxt : g[cur]) {
            if (nxt == from) continue;
            dfs(nxt, cur, step + 1, fork * (g[cur].size() - 1));
        }
    }
}

class Solution {
    public String oddString(String[] words) {
        String base;
        int n = words.length;
        if (isSameStrDiffArr(words[0], words[1])) {
            base = words[0];
        } else if (isSameStrDiffArr(words[0], words[2])) {
            base = words[0];
        } else {
            base = words[1];
        }

        for (String word : words) {
            if (!isSameStrDiffArr(word, base)) return word;
        }
        return null;
    }


    private boolean isSameStrDiffArr(String s1, String s2) {
        int n = s1.length();
        for (int i = 1; i < n; i++) {
            int a = s1.charAt(i) - s1.charAt(i - 1);
            int b = s2.charAt(i) - s2.charAt(i - 1);
            if (a != b) return false;
        }
        return true;
    }

}
