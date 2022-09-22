package 动态规划;

import java.util.Arrays;

//动态规划
public class 跳跃游戏II {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        //dp[i] : 到达i下标的最小步数
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j <= i + nums[i]; j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
                if (j == n - 1) {
                    return dp[j];
                }
            }
        }
        return dp[n - 1];
    }
}

//贪心，每一步都选择走的最远的,一次遍历，维护一个能走到的最大下标maxIndex
class dewcewcw {
    public int jump(int[] nums) {
        int step = 0;
        int end = 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxIndex = Math.max(maxIndex, i + nums[i]);
            if (maxIndex >= nums.length - 1) return step + 1;
            if (i >= end) {
                step++;
                end = maxIndex;
            }
        }
        return step;
    }

}