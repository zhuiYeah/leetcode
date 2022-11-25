package 动态规划;

import java.util.HashSet;


//前两个数字唯一的确定一个斐波那契数列

//纯暴力，不算动态规划吧
public class 最长的斐波那契子序列的长度 {
    public static int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        //dp[i] : 以下标i的数字作为子序列的结尾，斐波那契子序列的最长长度为dp[i]
        var set = new HashSet<Integer>();
        for (int k : arr) set.add(k);
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = arr[i], b = arr[j];
                if (!set.contains(a + b)) continue;
                int count = 2;
                while (set.contains(a + b)) {
                    var tmp = a;
                    a = b;
                    b = tmp + b;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }

}
