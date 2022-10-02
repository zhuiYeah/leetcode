package 字符串;

public class KMP重复的子字符串 {
    public boolean repeatedSubstringPattern(String s) {
        return false;
    }

    public int[] getNext(String s) {
        int n = s.length();
        int[] next = new int[n];
        next[0] = 0;
        int j = 0;
        int i = 1;
        for (; i < n; i++) {
            while(j>0 && s.charAt(j) != s.charAt(i)){
                j = next[j-1];
            }
            if (s.charAt(j) == s.charAt(i)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }

}
