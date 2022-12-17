package _周赛;

//长度为5的回文子序列的全部数目

//前后缀处理 + 中心枚举
public class __统计回文子序列数目 {
    final int MOD = (int) 1e9 + 7;

//    public int countPalindromess(String s) {
//        int n = s.length();
//        var dp = new long[n][n];
//        for (int j = 0; j < n; j++) {
//            dp[j][j] = 1;
//            for (int i = j - 1; i >= 0; i--) {
//                if (s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + 1;
//                else dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
//            }
//        }
//        return (int) dp[0][n - 1];
//    }

    public int countPalindromes(String S) {
        var s = S.toCharArray();
        int n = s.length;
        //pre[i]:实时记录  之前的数字i的个数
        int[] pre = new int[10], suf = new int[10];
        //suf2[a][b] 实时记录 位置 之后 的ab的个数
        int[][] pre2 = new int[10][10], suf2 = new int[10][10];
        for (int i = n - 1; i >= 0; i--) {
            var a = s[i] - '0';
            for (int b = 0; b < 10; b++) suf2[a][b] += suf[b];
            suf[a]++;
        }

        long ans = 0;
        for (int i = 0; i < s.length; i++) {
            int a = s[i] - '0';
            //更新（删减）suf 和 suf2
            suf[a]--;
            for (int b = 0; b < 10; b++) suf2[a][b] -= suf[b];
            // 以i作为中心的子序列总数
            for (int j = 0; j < 10; j++)
                for (int k = 0; k < 10; k++)
                    ans += (long) suf2[j][k] * pre2[k][j];
            ans %= MOD;
            //更新 pre和pre2
            for (int b = 0; b < 10; b++) pre2[b][a] += pre[b];
            pre[a]++;
        }
        return (int) ans;
    }
}


//暴力的前后缀处理  + 中心枚举
//超时 ，前后缀处理需要优化

class dedede {
    final int MOD = (int) 1e9 + 7;

    public int countPalindromes(String S) {
        int n = S.length();
        var pre = new int[n][10][10];
        var suf = new int[n][10][10];
        long res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = S.charAt(i) - '0', b = S.charAt(j) - '0';
                for (int k = j + 1; k < n; k++) {
                    pre[k][a][b]++;
                }
                for (int k = i - 1; k >= 0; k--) {
                    suf[k][a][b]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int a = 0;a < 10; a++){
                for (int b = 0;b < 10; b++){
                    res =  (res + (long) suf[i][b][a] * pre[i][a][b])%MOD;
                }
            }
        }
        return (int) res;
    }
}
