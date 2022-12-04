package 动态规划.背包问题;

import java.util.Arrays;

//先物品后背包，背包从大到小
public class 分割等和子集 {
    public boolean canPartition(int[] nums) {
        int cap = Arrays.stream(nums).sum();
        if (cap % 2 != 0) return false;
        cap /= 2;
        //dp[i] : 容量为i的背包能装载放入最大价值
        var dp = new int[cap + 1];
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = cap; j > 0; j--) {
                if (nums[i] <= j) {
                    dp[j] = Math.max(dp[j - nums[i]] + nums[i], dp[j]);
                }
            }
        }
        return dp[cap] == cap;
    }
}
