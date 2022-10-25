package 动态规划;

public class 前n个数字二进制中1的个数 {
    public int[] countBits(int n) {
        var dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        int maxbit = 1;
        for (int i = 2; i < n; i++) {
            if (i == 2 * maxbit) {
                maxbit = i;
            }
            dp[i] = dp[i - maxbit] + 1;
        }
        return dp;
    }
}
