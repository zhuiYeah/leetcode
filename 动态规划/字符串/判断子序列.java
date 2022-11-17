package 动态规划.字符串;

//s是否是t的子序列


import java.util.ArrayList;

//动态规划 6ms，应用在 匹配子序列的单词数 这种大数据情况时 ， 超时
public class 判断子序列 {
    public boolean isSubsequence(String s, String t) {
        int m = s.length(), n = t.length();
        if (m == 0) return true;
        var dp = new int[m + 1][n + 1]; //dp[i][j] :当前s下标为i-1，t下标为j-1，当前的公共子序列长度为dp[i][j]
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] == m) return true;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return false;
    }
}


//二分查找 2ms
class edede {
    public boolean isSubsequence(String sub, String s) {
        int n = sub.length();
        ArrayList[] g = new ArrayList[26];
        for (int i = 0; i < g.length; i++) g[i] = new ArrayList<Integer>();
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            g[index].add(i);
        }
        int left = 0; //当前可以选择s从left开始的所有下标
        for (int i = 0; i < n; i++) {
            int index = sub.charAt(i) - 'a';
            int l = 0, r = g[index].size() - 1;
            int xx = -1; //找到的大于等于left的最小下标
            while (l <= r) {
                int mid = l + (r - l) / 2;
                int idx = (int) g[index].get(mid);
                if (idx >= left) {
                    xx = idx;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            if (xx == -1) return false;
            else left = xx + 1;
        }

        return true;
    }
}
