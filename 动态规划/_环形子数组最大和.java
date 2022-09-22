package 动态规划;

import java.util.Arrays;

//解题思路：
//分两种情况，一种为没有跨越边界的情况，一种为跨越边界的情况
//没有跨越边界的情况直接求子数组的最大和即可；
//跨越边界的情况可以对数组求和再减去无环的子数组的最小和，即可得到跨越边界情况下的子数组最大和；
//求以上两种情况的大值即为结果，另外需要考虑全部为负数的情况
public class _环形子数组最大和 {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        int[] dpMax = new int[n];
        int[] dpMin = new int[n];
        int max = nums[0]; //记录连续子数组的最大和
        int min = nums[0]; //记录连续子数组的最小和
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dpMax[i] = Math.max(dpMax[i - 1] + nums[i], nums[i]);
            dpMin[i] = Math.min(dpMin[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dpMax[i]);
            min = Math.min(min, dpMin[i]);
        }
        if (max < 0) return max;

        return Math.max(max, sum - min);
    }

//    public boolean allFu(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] > 0) {
//                return false;
//            }
//        }
//        return true;
//    }
}
