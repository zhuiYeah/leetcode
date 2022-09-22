package 动态规划;

import java.util.Arrays;

//O (n^2)
public class _最长数对链 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int n = pairs.length;
        int[] dp = new int[n]; //dp[i]: 必须以pairs作为数对链的结尾，当前数对链的长度为dp[i]
        //int res = 1;
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            //res = Math.max(res, dp[i]);
        }
        return dp[n - 1];
    }
}
