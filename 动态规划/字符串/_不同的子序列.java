package 动态规划.字符串;

import java.util.Arrays;

//s的子序列有多少是和t完全一样的
public class _不同的子序列 {
    public static int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) return 0;
        var dp = new int[m + 1][n + 1];
        //dp[i][j] : s.substring(0,i) 中包含了 dp[i][j] 个 t.substring(0,j)
        //注意 在计算dp[i][j]时 ， 所在的字符下标为 i-1 ， j-1
        for (int i = 0; i < m + 1; i++) dp[i][0] = 1;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        numDistinct("rabbbit", "rabbit");
    }
}


//剑指offer
class dewfwe {

    public static int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) return 0;
        //dp[i][j] : s[0:i) 中包含了几个t[0:j)
        var dp = new int[m + 1][n + 1];
        for (int i = 0; i < dp.length; i++) dp[i][0] = 1; //s总能包含一个 ""
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    //新的s.charAt(i - 1)有贡献，用上这个新增的贡献，则有dp[i-1][j-1]包含；不用这个贡献，直接继承s[0:i-2]对t[0:j-1]的包含情况，则有dp[i-1][j]种包含
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    //新的s.charAt(i - 1)无任何贡献，直接继承s[0:i-2]对t[0:j-1]的包含情况即dp[i-1][j]
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

}
