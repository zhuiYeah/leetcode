package 贪心;

import java.util.Arrays;

//对数组中的每个元素，进行 +k或者 -k ，找到这么操作之后数组的MIN（max - min）

public class _最小差值II {
    public int smallestRangeII(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) return 0;
        Arrays.sort(nums);

        int A = nums[0], D = nums[n - 1];
        int res = D - A;
        for (int i = 0; i < n - 1; i++) {
//            if (i == 0) {
//                int max = Math.max(A + k, D);
//                int min = Math.min(A + k, nums[1] - k);
//                res = Math.max(res, max - min);
//                continue;
//            }
            int max = Math.max(nums[i] + k, D - k);
            int min = Math.min(nums[i + 1] - k, A + k);
            res = Math.min(res, max - min);
        }
        return res;
    }
}
