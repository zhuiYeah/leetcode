package 动态规划;

public class 跳跃游戏 {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 1) return true;
        int[] dp = new int[n];
        //dp[i] : 在位置i时，我还能移动的最大步数为dp[i]
        dp[0] = nums[0];
        if (dp[0] == 0) return false;
        if (dp[0] >= n - 1) return true;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] - 1, nums[i]);
            if (dp[i] == 0) {
                return false;
            }
            if (dp[i] + i >= n - 1) {
                return true;
            }
        }
        return false;
    }
}
