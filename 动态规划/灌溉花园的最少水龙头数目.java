package 动态规划;

import java.util.ArrayList;
import java.util.HashSet;

/**在 x 轴上有一个一维的花园。花园长度为 n，从点 0 开始，到点 n 结束。

 花园里总共有 n + 1 个水龙头，分别位于 [0, 1, ..., n] 。

 给你一个整数 n 和一个长度为 n + 1 的整数数组 ranges ，其中 ranges[i] （下标从 0 开始）表示：如果打开点 i 处的水龙头，可以灌溉的区域为 [i -  ranges[i], i + ranges[i]] 。

 请你返回可以灌溉整个花园的 最少水龙头数目 。如果花园始终存在无法灌溉到的地方，请你返回 -1 。*/
public class 灌溉花园的最少水龙头数目 {
    public int minTaps(int n, int[] ranges) {
        //线段的预处理
        var scopes = new ArrayList<int[]>();
        int max = 0;
        for (int i = 0; i < ranges.length; i++) {
            int l = Math.max(0, i - ranges[i]), r = Math.min(i + ranges[i], n);
            if (l == r || r <= max) continue;
            max = r;
            scopes.add(new int[]{l, r});
        }
        int m = scopes.size();
        //判断能否全覆盖
        var set = new HashSet<Integer>();
        for (int i = 0; i <= n; i++) set.add(i);
        for (int i = 0; i < m; i++) {
            int l = scopes.get(i)[0], r = scopes.get(i)[1];
            for (int j = l; j <= r; j++) set.remove(j);
        }
        if (set.size() != 0) return -1;


        int res = m;
        int[] dp = new int[m]; //dp[i] = 必须选择第i个范围，并且能达到 0 ～ i右端点 的连通，所需要的最小线段个数 ,0表示不能连通
        for (int i = 0; i < m; i++) {
            int l = scopes.get(i)[0], r = scopes.get(i)[1];
            dp[i] = m;
            if (l == 0) dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (scopes.get(j)[1] < l) continue;
                dp[i] = Math.min(dp[i], dp[j] + 1);
            }
            if (r == n) res = Math.min(dp[i], res);
        }
        return res;
    }
}
