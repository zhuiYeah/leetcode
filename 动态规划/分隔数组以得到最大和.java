package 动态规划;

//将一个数组任意切割，但最大子数组长度为k，切割后子数组中的数字全部变为其中的最大值，给出切割后数组的最大和


public class 分隔数组以得到最大和 {
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        var dp = new int[n];
        //dp[i] : 以nums[i]为切割的结尾，目前切割所能得到的最大值为dp[i]
        dp[0] = arr[0];
        int max = arr[0];
        //初始化dp数组
        for (int i = 1; i < k; i++) {
            max = Math.max(max, arr[i]);
            dp[i] = max * (i + 1);
        }
        for (int i = k; i < n; i++) {
            //想要得到dp[i]的值 ， 那么对于当前的arr[i]来说，以他作为结尾，有k种分配方法
            //从i位置向前追溯7个， (i-j+1)即表示追溯到第（i-j+1）个了，
            //于是dp[i] = Math.max(dp[i],max*dp(i-j+1) + dp[i-(i-j)+1])
            max = arr[i];
            for (int j = i; j >= i - k + 1; j--) {
                max = Math.max(max, arr[j]);
                int tmp = max * (i - j + 1) + dp[i - (i - j + 1)];
                dp[i] = Math.max(dp[i], tmp);
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        maxSumAfterPartitioning(new int[]{1, 15, 7, 9, 2, 5, 10}, 3);
    }
}
