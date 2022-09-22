package 动态规划;

public class 乘积最大子数组 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] dpMax = new int[n];
        int[] dpMin = new int[n];
        //dpMin[i] : 乘以nums[i]之后的最小值为dpMin[i]
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            dpMax[i] = Math.max(nums[i] * dpMax[i - 1], Math.max(nums[i] * dpMin[i - 1], nums[i]));
            dpMin[i] = Math.min(nums[i] * dpMin[i - 1], Math.min(nums[i] * dpMax[i - 1], nums[i]));
            max = Math.max(max, dpMax[i]);
        }
        return max;
    }
}
