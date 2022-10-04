package 动态规划;

import java.util.Arrays;
import java.util.OptionalInt;

public class 打家劫舍II {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            int max = 0;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            return max;
        }
        var dp1 = new int[n - 1];
        var dp2 = new int[n];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[1], nums[0]);
        dp2[1] = nums[1];
        dp2[2] = Math.max(nums[2], nums[1]);
        for (int i = 2; i < dp1.length; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
        }
        for (int i = 3; i < dp2.length; i++) {
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
        }
        return Math.max(dp1[dp1.length - 1], dp2[dp2.length - 1]);
    }
}
