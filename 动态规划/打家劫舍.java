package 动态规划;

public class 打家劫舍 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length == 1) return nums[0];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}


//剑指offer
class dewadfew {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        var dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        return dp[n - 1];
    }
}
