package 图;

import java.util.ArrayList;

public class 通知所有员工所需的时间 {
    int res = 0;
    int[] manager;
    int[] informTime;
    ArrayList<Integer>[] g;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        this.manager = manager;
        this.informTime = informTime;
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = manager[i], b = i;
            if (a == -1) continue;
            g[a].add(b);
        }
        dfs(headID, 0);
        return res;
    }

    private void dfs(int cur, int curUsedTime) {
        res = Math.max(res, curUsedTime);
        for (int nxt : g[cur]) dfs(nxt, curUsedTime + informTime[cur]);
    }
}
