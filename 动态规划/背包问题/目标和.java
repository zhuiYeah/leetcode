package 动态规划.背包问题;

import java.util.Arrays;

//剑指offer
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


class edede {
    public int findTargetSumWays(int[] nums, int target) {
        //a + b = sum
        //a - b = target
        int sum = Arrays.stream(nums).sum();
        if ((sum + target) % 2 == 1) return 0;
        if (Math.abs(target) > sum) return 0;
        int cap = (sum + target) / 2;
        //放满容量为cap的背包有几种方法
        var dp = new int[cap + 1];
        dp[0] = 1; //计放满空背包的方法有一种
        for (int i = 0; i < nums.length; i++) {
            for (int j = cap; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[cap];
    }
}


//class ededswe {
//    public int findTargetSumWays(int[] nums, int target) {
//        //a + b = sum
//        //a - b = target
//        int sum = Arrays.stream(nums).sum();
//        if ((sum + target) % 2 == 1) return 0;
//        if (Math.abs(target) > sum) return 0;
//        int cap = (sum + target) / 2;
//        //dp[i][j] : 物品0～i，背包容量为j，放满背包的方法有dp[i][j]种
//        var dp = new int[nums.length][cap + 1];
//        for (int i = 0; i < nums.length; i++) dp[i][0] = 1;
//        dp[0][nums[0]] = 1;
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = nums[i]; j <= cap; j++) {
//                dp[i][j] += dp[i - 1][j - nums[i]];
//            }
//        }
//        return dp[nums.length - 1][cap];
//    }
//}