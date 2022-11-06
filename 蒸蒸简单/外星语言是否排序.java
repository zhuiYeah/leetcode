package 蒸蒸简单;

import java.util.HashMap;

public class 外星语言是否排序 {
    private HashMap<Character, Integer> map = new HashMap<Character, Integer>();

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < order.length(); i++) map.put(order.charAt(i), i);
        for (int i = 1; i < words.length; i++) {
            if (!is2bigger1(words[i - 1], words[i])) return false;
        }
        return true;
    }

    private boolean is2bigger1(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        for (int i = 0; i < Math.min(m, n); i++) {
            int b = map.get(word2.charAt(i));
            int a = map.get(word1.charAt(i));
            if (b < a) return false;
            if (b > a) return true;
        }
        return n >= m;
    }

}
