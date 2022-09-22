package 动态规划;

import java.util.Arrays;

//01背包
//nums里面的数字通过加减 最后结果等于 target ，一共有几种可能的组合方式
public class 目标和 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if ((sum + target) % 2 != 0) {
            return 0;
        }
        if (Math.abs(target) > sum) {
            return 0;
        }
        int bagCapability = (sum + target) / 2;
        int[] dp = new int[bagCapability + 1]; //dp[i]:装满容量为i的背包有几种方法
        //初始化dp数组
        dp[0] = 1;
        if (bagCapability >= nums[0]) {
            dp[nums[0]]++;
        }
        //开始动态规划
        for (int i = 1; i < nums.length; i++) { //遍历物品
            for (int j = bagCapability; j >= nums[i]; j--) {//遍历背包
                dp[j] += dp[j - nums[i]];
            }
        }

        return dp[bagCapability];
    }
}
