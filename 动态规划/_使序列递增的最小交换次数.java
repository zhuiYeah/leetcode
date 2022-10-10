package 动态规划;

public class _使序列递增的最小交换次数 {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        var dp = new int[n][2];
        //dp[i][0] : 第i个元素不交换 并且能够满足递增 ， 当前所用的最小交换次数
        //dp[i][1] : 第i个元素交换  并且能够满足递增，当前所用的交换次数
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            //满足递增规矩
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                //满足递增规律并且大于对面的前一个数，这种时候换不换都可以
                if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                    dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]);
                    dp[i][1] = Math.min(dp[i - 1][1], dp[i - 1][0]) + 1;
                } else {
                    //// 那么这里就是并不大于对位数的时候，那么同一数组里的i和i-1必须绑定在一起
                    //i不交换，i-1也必须不能交换
                    dp[i][0] = dp[i - 1][0];
                    //i交换，i-1必须交换
                    dp[i][1] = dp[i - 1][1] + 1;
                }
            } else {
                //不满足递增规律，那么必须nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]
                //那么同一数组里的i和i-1必须错开
                //i不交换，i-1必须交换
                dp[i][0] = dp[i - 1][1];
                //i交换，i-1必须不交换
                dp[i][1] = dp[i - 1][0] + 1;
            }
        }
        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }
}
