package 前缀和;

public class 有序数组中差绝对值之和 {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        var presum = new long[n];
        var postsum = new long[n];
        presum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            presum[i] = nums[i] + presum[i - 1];
        }
        postsum[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            postsum[i] = nums[i + 1] + postsum[i + 1];
        }
        int[] res = new int[n];
        int precount = 1;
        for (int i = 0; i < n; i++, precount++) {
            res[i] = (int) ((nums[i] * precount - presum[i]) + (postsum[i] - (n - precount) * nums[i]));

        }
        return res;
    }
}
