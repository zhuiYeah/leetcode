package 动态规划;

//s3是否可以由s1，s2交错组成

public class _交错字符串 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        int m = s1.length();
        int n = s2.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        //dp[i][j] : s1的前i个字符和s2的前j个字符能否交错组成s3的前i+j个字符
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int index = i + j - 1;
                if (j > 0) {
                    dp[i][j] = dp[i][j] || s2.charAt(j - 1) == s3.charAt(index) && dp[i][j - 1];
                }
                if (i > 0) {
                    dp[i][j] = dp[i][j] || s1.charAt(i - 1) == s3.charAt(index) && dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
}
