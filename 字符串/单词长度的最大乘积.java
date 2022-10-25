package 字符串;

//暴力匹配每个字符串
public class 单词长度的最大乘积 {
    public int maxProduct(String[] words) {
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isValid(words[j], words[i])) {
                    max = Math.max(max, words[j].length() * words[i].length());
                }
            }
        }
        return max;
    }

    public boolean isValid(String word1, String word2) {
        var w1 = new boolean[26];
        for (int i = 0; i < word1.length(); i++) {
            w1[word1.charAt(i) - 'a'] = true;
        }
        for (int i = 0; i < word2.length(); i++) {
            if (w1[word2.charAt(i) - 'a']) return false;
        }
        return true;
    }
}
