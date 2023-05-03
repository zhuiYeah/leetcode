package 图;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class 不邻接植花 {
    int[] res;
    ArrayList<Integer>[] g;

    public int[] gardenNoAdj(int n, int[][] paths) {
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] p : paths) {
            int a = p[0] - 1, b = p[1] - 1;
            g[a].add(b);
            g[b].add(a);
        }
        res = new int[n];
        for (int i = 0; i < n; i++) {
            dfs(i);
        }
        return res;
    }

    private void dfs(int cur) {
        if (res[cur] != 0) return;
        int i = choiceOneColor(cur);
        res[cur] = i;
        for (int nxt : g[cur]) {
            dfs(nxt);
        }
    }

    private int choiceOneColor(int cur) {
        Set<Integer> set = new HashSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        for (int nxt : g[cur]) {
            set.remove(res[nxt]);
        }
        for (int x : set) {
            return x;
        }
        return -1;
    }
}
