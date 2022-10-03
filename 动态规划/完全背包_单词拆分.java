package 动态规划;

import java.util.List;

public class 完全背包_单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        var dp = new boolean[s.length() + 1];
        //dp[i] : 字符串s的前i个字符能否被 wordDict中的单词填满
        dp[0] = true;
        //我们知道完全背包先遍历物品先遍历背包都可以，但本题先遍历背包
        for (int i = 1; i < dp.length; i++) {
            //现在背包容量是i
            for (String value : wordDict) {
                int jSize = value.length();
                if (i >= jSize) {
                    if (dp[i - jSize] && s.substring(i - jSize, i).equals(value)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.length()];
    }
}
