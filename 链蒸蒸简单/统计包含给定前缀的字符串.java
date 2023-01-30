package 链蒸蒸简单;

public class 统计包含给定前缀的字符串 {
    public int prefixCount(String[] words, String pref) {
        int cnt = 0;
        for (String word : words) if (word.startsWith(pref)) cnt++;
        return cnt;
    }
}
