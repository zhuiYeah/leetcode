package 滑动窗口;

/**
 * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums
 * 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
 * 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
 **/


/**
 * 找到 和为 sum-x的子数组， 并且使得子数组的长度最长
 **/
public class 将x减到0的最小操作数 {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        if (nums[0] > x && nums[n - 1] > x) return -1;
        if (nums[0] == x || nums[n - 1] == x) return 1;
        int tot = 0;
        for (int num : nums) tot += num;
        if (tot < x) return -1;
        if (tot == x) return n;
        int k = tot - x;
        //找到和为k的最长子数组的长度
        int maxSubLength = getMaxSubArr(nums, k);
        return maxSubLength == -1 ? -1 : n - maxSubLength;

    }

    //找到和为k的最长子数组的长度，滑动窗口
    //滑动窗口模板
    private int getMaxSubArr(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0, sum = 0, res = -1;
        while (right < n) {
            sum += nums[right];
            while (sum > k) {
                sum -= nums[left];
                left++;
            }
            if (sum == k) res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
