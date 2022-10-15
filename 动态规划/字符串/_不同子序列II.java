package 动态规划.字符串;

import java.util.Arrays;

//给出s的所有不同子序列的个数


class dewdewde {
    public int distinctSubseqII(String s) {
        var dp = new long[26];
        final long MOD = (long) (1e9 + 7);
        //dp[i] ：以 i+'a' 结尾的序列一共有dp[i]种
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            dp[index] = (Arrays.stream(dp).sum() + 1) % MOD;
        }
        return (int) (Arrays.stream(dp).sum() % MOD);
    }
}

public class _不同子序列II {
    public int distinctSubseqII(String s) {
        var dp = new int[26];
        final int MOD = 1000000007;
        //dp[i] ：以 i+'a' 结尾的序列一共有dp[i]种
        int sum = 0;
        //sum记录到目前为止出现的总序列数目
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            int tmp = dp[index];
            dp[index] = (sum + 1) % MOD;
            //由于存在取余运算，减法可能出现负数，为保证不出现负数
            sum = ((sum + dp[index] - tmp) % MOD + MOD) % MOD;
        }
        return sum % MOD;
    }
}



