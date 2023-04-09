package 图;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class 最大网络秩 {
    public int maximalNetworkRank(int n, int[][] roads) {
        ArrayList<Integer>[] g = new ArrayList[n];
        boolean[][] gg = new boolean[n][n];
        for (int i = 0; i < g.length; i++) g[i] = new ArrayList<Integer>();
        for (int[] r : roads) {
            int a = r[0], b = r[1];
            g[a].add(b);
            g[b].add(a);
            gg[a][b] = gg[b][a] = true;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (gg[i][j]) max = Math.max(max, g[i].size() + g[j].size() - 1);
                else max = Math.max(max, g[i].size() + g[j].size());
            }
        }
        return max;
    }
}
