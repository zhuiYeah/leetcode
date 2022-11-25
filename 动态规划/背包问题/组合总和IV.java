package 动态规划.背包问题;

//剑指offer
//装满背包的不同排列数 先背包再物品哦
public class 组合总和IV {
    public int combinationSum4(int[] nums, int target) {
        var dp = new int[target + 1];//dp[j]:装满j背包有dp[j]种组合
        dp[0] = 1;

        for (int j = 1; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j >= nums[i]) dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
