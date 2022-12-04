package 记忆化搜索;

//记忆化搜索
public class 最大平均值和的分组 {
    double[][] f;//f[i][k]:从nums[i]起，将数组分成k份，得到的最大平均值和为f[i][k]
    int[] nums;
    int n;

    public double largestSumOfAverages(int[] nums, int k) {
        n = nums.length;
        this.nums = nums;
        f = new double[n][k + 1];
        return f(0, k);
    }

    private double f(int i, int k) {
        if (i >= n) return 0;
        if (f[i][k] != 0) return f[i][k];
        double sum = 0;
        if (k == 1) {
            for (int j = i; j < nums.length; j++) sum += nums[j];
            f[i][k] = sum / (n - i);
            return f[i][k];
        }
        //枚举从i位置开始的全部子数组
        for (int j = i; j < n; j++) {
            sum += nums[j];
            double aver = sum / (j - i + 1);
            double tmp = f(j + 1, k - 1);
            f[i][k] = Math.max(f[i][k], aver + tmp);
        }

        return f[i][k];
    }
}

//从记忆化搜索到动态规划
class dede {
    public double largestSumOfAverages(int[] nums, int k) {
        int n = nums.length;
        double[][] dp = new double[n+1][k + 1];
        //dp[i][k]： 以nums[i]结束，将数组分成k份，得到的最大平均值和为dp[i][k]
        var preSum = new double[n+1];

        for (int i = 0; i < n; i++) {
            preSum[i +1 ] = preSum[i] + nums[i];
            dp[i+1][1] = preSum[i+1] / (i + 1);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= Math.min(k, i); j++) {
                for (int t = 0; t < i; t++) {
                    dp[i][j] = Math.max(dp[i][j], dp[t][j - 1] + (preSum[i] - preSum[t]) / (i - t));
                }
            }
        }
        return dp[n][k];
    }

}
