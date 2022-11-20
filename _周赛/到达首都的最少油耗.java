package _周赛;

import java.util.*;

public class 到达首都的最少油耗 {
    long res = 0;
    int SEATS;
    // 映射 点 和 他的全部能到达点
    Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();

    public long minimumFuelCost(int[][] roads, int seats) {
        SEATS = seats;
        for (int[] road : roads) {
            var x = map.getOrDefault(road[0], new HashSet<Integer>());
            x.add(road[1]);
            map.put(road[0], x);
            x = map.getOrDefault(road[1], new HashSet<Integer>());
            x.add(road[0]);
            map.put(road[1], x);
        }
        dfs(-1, 0);
        return res;
    }

    // 告诉父节点本子树一共携带多少人
    private int dfs(int father, int me) {
        if (map.get(me) == null)
            return 0;
        var x = map.get(me);
        int sum = 0;
        for (int son : x) {
            if (son == father)
                continue;
            // 这条相邻路线将会携带willtake个人
            int willtake = dfs(me, son);
            res += willtake % SEATS == 0 ? willtake / SEATS : willtake / SEATS + 1;
            sum += willtake;
        }
        return sum + 1;
    }
}