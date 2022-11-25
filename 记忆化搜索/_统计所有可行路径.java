package 记忆化搜索;

import java.util.Arrays;

//从数组的一个位置走到另一个位置的油耗为两数之差 ， 从start 到 finish ， 油量一共为fuel ，有多少条路径（可以重复经过一个点，包括起点终点）

public class _统计所有可行路径 {
    int[] locations;
    int n;
    int finish;
    long[][] memo; //memo[i][j] :当前在i位置，当前油量还剩j，到达终点的路径数量有memo[i][j]条
    final int MOD = (int) 1e9 + 7;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        this.locations = locations;
        n = locations.length;
        this.finish = finish;
        memo = new long[n][fuel + 1];
        for (long[] longs : memo) Arrays.fill(longs, -1);
        return (int) f(start, fuel);
    }


    private long f(int idx, int rest) {
        if (memo[idx][rest] != -1) return memo[idx][rest];

        memo[idx][rest] = 0;
        //当前位置已经是死路 无论如何不能到达终点
        if (rest < Math.abs(locations[idx] - locations[finish])) return 0;


        long res = 0;
        //枚举下一步能走的全部路径，累加
        for (int i = 0; i < n; i++) {
            if (i == idx) continue;
            if (rest < Math.abs(locations[idx] - locations[i])) continue;
            res = (res + f(i, rest - Math.abs(locations[idx] - locations[i]))) % MOD;
        }
        memo[idx][rest] = res;

        if (idx == finish) memo[idx][rest]++;
        return memo[idx][rest];
    }


}
