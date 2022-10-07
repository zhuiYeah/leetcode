package 动态规划.字符串;

public class __正则表达式匹配 {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        var dp = new boolean[m + 1][n + 1];
        //dp[i][j]: s[:i]和 p[0:j] 能否匹配 ，注意dp[i][j]是去讨论s[i-1] 和 p[j-1]
        dp[0][0] = true;
        //初始化，即p能不能去匹配空字符串
        for (int j = 2; j <= n; j += 2) {
            dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    //让前一个字符（p[j-2]）出现0次
                    if (dp[i][j - 2]) {
                        dp[i][j] = true;
                    }
                    //让前一个字符（）多出现一次
                    if (dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                        dp[i][j] = true;
                    }
                } else {
                    if (dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp[m][n];

    }
}
