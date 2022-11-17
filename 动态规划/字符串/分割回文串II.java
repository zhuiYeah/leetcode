package 动态规划.字符串;

//把一个字符串分割成全部回文子串的最小分割次数


//dp预处理 + 线性dp
public class 分割回文串II {
    public int minCut(String s) {
        int n = s.length();
        //dp[i:j] : s[i:j]是否为回文串
        var dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (j == i) {
                    dp[i][j] = true;
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1) {
                        dp[i][j] = true;
                        continue;
                    }
                    if (dp[i + 1][j - 1]) dp[i][j] = true;
                }
            }
        }
        //f[i] : 抉择完第i个字符串后，最小分割次数为f[i];
        var f = new int[n];
        for (int i = 0; i < n; i++) f[i] = i;
        for (int i = 1; i < n; i++) {
            if (dp[0][i]) {
                f[i] = 0;
                continue;
            }
            for (int j = 1; j <= i; j++) {
                if (dp[j][i]) f[i] = Math.min(f[i], f[j - 1] + 1);
            }
        }
        return f[n - 1];
    }
}
