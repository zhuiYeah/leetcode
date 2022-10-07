package 蒸蒸简单;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 单词规律 {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;
        Map<Character, String> map = new HashMap<Character, String>();
        Set<String> allowed = new HashSet<String>();
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(pattern.charAt(i))) {
                String ss = map.get(pattern.charAt(i));
                if (!ss.equals(words[i])) return false;
            } else {
                if (allowed.contains(words[i])) return false;
                allowed.add(words[i]);
                map.put(pattern.charAt(i), words[i]);
            }
        }
        return true;
    }
}
