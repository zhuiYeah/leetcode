package 动态规划.背包问题;

import java.util.Arrays;

public class 完全背包_零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        //dp[j]: 背包容量为j时，装满背包的最小硬币个数为dp[j]
        Arrays.fill(dp, Integer.MAX_VALUE-10000);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i]) {
                    dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE-10000 ? -1 : dp[amount];
    }
}


//先物品后背包，背包由小到大
class dewdfew{
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        //dp[j]: 背包容量为j时，装满背包的最小硬币个数为dp[j]
        Arrays.fill(dp, Integer.MAX_VALUE-10000);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i]) {
                    dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE-10000 ? -1 : dp[amount];
    }
}
