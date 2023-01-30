package 链蒸蒸简单;

public class 交替合并字符串 {
    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int i = 0, j = 0;
        int mask = 0;
        StringBuilder res = new StringBuilder();
        while (i < m && j < n) {
            if (mask == 0) {
                res.append(word1.charAt(i));
                i++;
            } else {
                res.append(word2.charAt(j));
                j++;
            }
            mask ^= 1;
        }
        if (i < m) res.append(word1.substring(i));
        if (j < n) res.append(word2.substring(j));
        return res.toString();
    }
}
