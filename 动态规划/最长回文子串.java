package 动态规划;

public class 最长回文子串 {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        //dp[i][j] : 第i个字符串到第j个字符串 之间的区间是否是回文子串
        int max = 1;
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        //因为参考左下角，所以我们需要从下往上遍历
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) ) {
                    if (dp[i + 1][j - 1] || j - i == 1) {
                        dp[i][j] = true;
                    }
                }
                if (dp[i][j]){
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(start, end+1);
    }
}
