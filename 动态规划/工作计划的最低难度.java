package 动态规划;

import java.util.Arrays;

/**
 * 将数组分成d份，分割后的代价为每一份的最大值之和，给出分割的最小代价
 */

/**
 * 输入：jobDifficulty = [6,5,4,3,2,1], d = 2
 * 输出：7
 * 分割方案 6 5 4 3 2         1
 * 这是代价最小的分割方案了
 */
public class 工作计划的最低难度 {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (d > n) return -1;
        long[][] dp = new long[n][d];        //dp[i][j] : 把 第i个任务作为第j（0～d-1）天的结尾，得到的最小难度
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        int[][] MAX = new int[n][n];  // MAX[i][j]: job[i]~job[j]中的最大值
        for (int i = 0; i < n; i++) {
            int max = jobDifficulty[i];
            for (int j = i; j < n; j++) {
                max = Math.max(max, jobDifficulty[j]);
                MAX[i][j] = max;
            }
        }
        //dp[i][j] = dp[ k (0 ~ i-1)][j-1]  + MAX[k+1][i]   枚举所有 k，找出其中最小值
        for (int i = 0; i < n; i++) dp[i][0] = MAX[0][i];

        for (int j = 1; j < d; j++) {
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[k][j - 1] + MAX[k + 1][i]);
                }
            }
        }
        return (int) dp[n - 1][d - 1];
    }
}
