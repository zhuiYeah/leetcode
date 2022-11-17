package 动态规划;

public class _多米诺和托米诺平铺 {
    public int numTilings(int n) {
        if (n <= 2) return n;
        int mod = (int) (1e9 + 7);
        var dp = new long[n + 1]; //当前是第i列的瓷砖，铺满它的方法有dp[i]种
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        var dpx = new long[n + 1];//当前是第i列的瓷砖，使它留一个角的方法有dpx[i]种
        dpx[2] = 2;
        dpx[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dpx[i - 1]) % mod;
            dpx[i] = (dp[i - 2] * 2 + dpx[i - 1]) % mod;
        }
        return (int) dp[n];
    }
}
