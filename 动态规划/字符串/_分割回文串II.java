package 动态规划.字符串;

//把一个字符串分割成全部回文子串的最小分割次数


//dp预处理 + 线性dp
public class _分割回文串II {
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


//剑指offer
class dede {
    public int minCut(String s) {
        int n = s.length();
        var isP = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    isP[i][j] = true;
                    continue;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j - 1 || isP[i + 1][j - 1]) isP[i][j] = true;
                }
            }
        }
        var dp = new int[n];
        //dp[i] : i为止的最小分割次数
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int min = i;
            if (isP[0][i]) {
                dp[i] = 0;
                continue;
            }
            for (int j = 1; j <= i; j++) {
                if (isP[j][i]) min = Math.min(min, dp[j - 1] + 1);
            }
            dp[i] = min;
        }
        return dp[n - 1];
    }
}