package 动态规划;

//cov最长公共子序列

//给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
//每步 可以删除任意一个字符串中的一个字符。
public class 两个字符串的删除操作 {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        var dp = new int[m + 1][n + 1];
        //dp[i][j] : word1[0:i]  与 word2[0:j]的最长公共子串长度为 dp[i][j]
        //注意 计算dp[i][j]时，对于的字符下标为 i-1 ， j-1
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return m + n - dp[m][n]*2;
    }
}
