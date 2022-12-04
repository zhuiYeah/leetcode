package 图;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//dfs找到最小边
public class 两个城市间路径的最小分数 {
    int min = Integer.MAX_VALUE;
    Map<Integer, Set<Integer>> map = new HashMap<>();
    Map<String, Integer> cost = new HashMap<>();
    Set<Integer> vis = new HashSet<>();

    public int minScore(int n, int[][] roads) {
        // 城市 -》 能直接到达的全部城市
        for (int[] road : roads) {
            int a = road[0], b = road[1], dis = road[2];

            var set = map.getOrDefault(a, new HashSet<Integer>());
            set.add(b);
            map.put(a, set);

            set = map.getOrDefault(b, new HashSet<Integer>());
            set.add(a);
            map.put(b, set);

            String s = a + "-" + b;
            cost.put(s, dis);
            s = b + "-" + a;
            cost.put(s, dis);
        }
        dfs(1);
        return min;
    }

    //要访问到全部的边哦 ， 所以 在什么时候判断重复呢？？
    private void dfs(int cur) {
        if (vis.contains(cur)) return;
        var nextAll = map.getOrDefault(cur, new HashSet<Integer>());
        vis.add(cur);
        for (int next : nextAll) {
            String s = cur + "-" + next;
            int cos = cost.get(s);
            min = Math.min(min, cos);
            dfs(next);
        }
    }
}
