package 链蒸蒸简单;

public class 最少操作使数组递增 {
    public int minOperations(int[] nums) {
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                res += nums[i - 1] + 1 - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
        }
        return res;
    }
}
