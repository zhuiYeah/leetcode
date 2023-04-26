package 动态规划;


import java.util.Arrays;

public class 最长等差数列 {
    //纯暴力
    public int longestArithSeqLength(int[] nums) {
        int res = 2;
        int n = nums.length;
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                int x = 2, pre = nums[j];
                int diff = nums[j] - nums[i];
                for (int k = j + 1; k < n; k++) {
                    if (nums[k] == pre + diff) {
                        pre = nums[k];
                        x++;
                    }
                }
                res = Math.max(res, x);
            }
        }
        return res;
    }

    //动态规划
    public int longestArithSeqLength2(int[] nums) {
        int res = 2;
        int n = nums.length;
        int[][] dp = new int[n][1005];
        //dp[i][j] ： 以nums[i]作为结尾，公差为j 的最长等差数列的长度
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // nums[j]   nums[i]  二元组已经确定
                int diff = nums[i] - nums[j] + 500;
                dp[i][diff] = dp[j][diff] + 1;
                res = Math.max(dp[i][diff], res);
            }
        }
        return res;
    }
}

class Test {
    public static void main(String[] args) {
        new 最长等差数列().longestArithSeqLength2(new int[]{9, 4, 7, 2, 10});
    }
}


