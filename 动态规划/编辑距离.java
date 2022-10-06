package 动态规划;

//给你两个单词word1 和word2， 请返回将word1转换成word2 所使用的最少操作数。
//你可以对一个单词进行如下三种操作：
//插入一个字符
//删除一个字符
//替换一个字符

//分析可以得知插入一个字符和删除一个字符没有区别，所以我们只考虑删除和替换
public class 编辑距离 {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        var dp = new int[m + 1][n + 1];
        //dp[i][j] ：使得 word1[0:i],word2[0:j] 相同的最小操作数
        //注意 计算dp[i][j]时，对应的字符下标为 i-1 ， j-1
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //不同时，要么word2回退 删除新增的word1的i-1，要么word1回退 删除新增的word2的j-1，要么同时回退 更换i-1，j-1的其中一个
                    dp[i][j] = Math.min(dp[i - 1][j],  Math.min(dp[i-1][j-1],dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
