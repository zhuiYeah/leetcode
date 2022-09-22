package DFS和BFS;

import java.util.*;

//人写傻了
public class _dfs引爆最多的炸弹 {
    boolean[] boomed;
    Map<Integer, Set<Integer>> next = new HashMap<>();
    int max = 0;

    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        boomed = new boolean[n];
        for (int i = 0; i < n; i++) {
            //当前位于炸弹i
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (j == i) {
                    continue;
                }
                if (isContain(bombs[i], bombs[j])) {
                    set.add(j);
                }
            }
            next.put(i, set);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            max = 0;
            for (int j = 0; j < n; j++) {
                boomed[j] = false;
            }
            dfs(i);
            res = Math.max(res, max);
        }
        return res;
    }

    public void dfs(int i) {
        boomed[i] = true;
        max++;
        Set<Integer> set = next.get(i);
        for (int next : set) {
            if (!boomed[next]) {
                dfs(next);
            }
        }
    }

    public boolean isContain(int[] bomb1, int[] bomb2) {
        long distance = (long) (bomb1[0] - bomb2[0]) * (bomb1[0] - bomb2[0]) + (long) (bomb1[1] - bomb2[1]) * (bomb1[1] - bomb2[1]);

        return distance <= (long) bomb1[2] * bomb1[2];
    }
}
