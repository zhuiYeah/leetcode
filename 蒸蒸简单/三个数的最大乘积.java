package 蒸蒸简单;

import java.util.Arrays;

public class 三个数的最大乘积 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n == 3) return nums[0] * nums[1] * nums[2];
//        if (nums[n - 1] == 0) return 0;
//        if (nums[0] == 0) return nums[n - 1] * nums[n - 2] * nums[n - 3];
//        if (nums[n - 1] < 0) return nums[n - 1] * nums[n - 2] * nums[n - 3];
//        if (nums[0] > 0) return nums[n - 1] * nums[n - 2] * nums[n - 3];
        if (nums[0] >= 0 || nums[n - 1] <= 0) return nums[n - 1] * nums[n - 2] * nums[n - 3];
        if (nums[1] < 0) {
            return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] * nums[n - 3]);
        } else {
            return nums[n - 1] * nums[n - 2] * nums[n - 3];
        }
    }
}
