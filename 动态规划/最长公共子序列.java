package 动态规划;


//找到两个字符串的最长公共子序列
public class 最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        var dp = new int[m][n];
        //dp[i][j]  ： text1的前i个字符和text2的前j个字符，他们的最长公共子序列为dp[i][j]
        for (int i = 0; i < dp.length; i++) {
            if (text1.charAt(i) == text2.charAt(0)) {
                dp[i][0] = 1;
                for (int x = i + 1; x < dp.length; x++) {
                    dp[x][0] = 1;
                }
                break;
            }
        }
        for (int j = 0; j < dp[0].length; j++) {
            if (text2.charAt(j) == text1.charAt(0)) {
                dp[0][j] = 1;
                for (int x = j + 1; x < dp[0].length; x++) {
                    dp[0][x] = 1;
                }
                break;
            }
        }
        //
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
