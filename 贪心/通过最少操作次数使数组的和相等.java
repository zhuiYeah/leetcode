package 贪心;

import java.util.Arrays;

//nums1 nums2数组只包含 数字 1～6 ，一次操作可以改变任意一个数字，通过最小操作次数使数组的和相等

//贪心 + 双指针
public class 通过最少操作次数使数组的和相等 {
    public int minOperations(int[] nums1, int[] nums2) {
        int sum1 = 0, sum2 = 0;
        for (int j : nums1) sum1 += j;
        for (int j : nums2) sum2 += j;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] big, small;
        int cnt = 0;
        if (sum1 == sum2) return cnt;
        if (sum1 < sum2) {
            big = nums2;
            small = nums1;
        } else {
            big = nums1;
            small = nums2;
        }
        int bignum = Arrays.stream(big).sum(), smallnum = Arrays.stream(small).sum();
        for (int i = 0; i < big.length / 2; i++) {
            var tmp = big[i];
            big[i] = big[big.length - 1 - i];
            big[big.length - 1 - i] = tmp;
        }
        int i = 0, j = 0;
        while (i < small.length || j < big.length) {
            int smallContribution = -1, bigContribution = -1;
            if (i < small.length) smallContribution = 6 - small[i];
            if (j < big.length) bigContribution = big[j] - 1;
            if (smallContribution >= bigContribution) {
                if (bignum - smallnum <= smallContribution) return cnt + 1;
                smallnum += smallContribution;
                cnt++;
                i++;
            } else {
                if (bignum - smallnum <= bigContribution) return cnt + 1;
                bignum -= bigContribution;
                cnt++;
                j++;
            }
        }
        return -1;
    }
}
