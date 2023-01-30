package 链蒸蒸简单;

import java.util.HashMap;

public class 最长回文串 {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int res = 0;
        boolean one = false;
        for (HashMap.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                res += entry.getValue();
            } else {
                res += entry.getValue() - 1;
                one = true;
            }
        }
        if (one) res++;
        return res;
    }
}
