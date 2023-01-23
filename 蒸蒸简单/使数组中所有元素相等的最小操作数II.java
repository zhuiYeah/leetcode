package 蒸蒸简单;

//分类思考
public class 使数组中所有元素相等的最小操作数II {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long sum1 = 0, sum2 = 0;
        for (int i : nums1) sum1 += i;
        for (int i : nums2) sum2 += i;
        if (sum1 != sum2) return -1;
        if (k == 0) {
            for (int i = 0; i < n; i++)
                if (nums1[i] != nums2[i]) return -1;
            return 0;
        }
        long diff = 0;
        for (int i = 0; i < n; i++) {
            int theDiff = Math.abs(nums1[i] - nums2[i]);
            if (theDiff % k != 0) return -1;
            diff += theDiff;
        }
        return diff / (2L * k);
    }
}

//4   3   1   4
//1   3   7   1
