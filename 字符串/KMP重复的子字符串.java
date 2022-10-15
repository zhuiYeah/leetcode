package 字符串;


import java.util.Arrays;

public class KMP重复的子字符串 {
    public boolean repeatedSubstringPattern(String s) {
        var next = getNext(s);
        int n = s.length();
        if (n == 1) return false;
        //最长相等前缀 = 最长相等后缀
        //最小重复子串 = n - 最长相等前（后）缀
        var lenOfMinSub = n - next[n - 1];
        if (lenOfMinSub == n) return false;
        return n % lenOfMinSub == 0;
    }

    public static int[] getNext(String s) {
        int n = s.length();
        int[] next = new int[n];
        next[0] = 0;
        int j = 0;
        int i = 1;
        for (; i < n; i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = next[j - 1];
            }
            if (s.charAt(j) == s.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getNext("abac")));
    }

}
