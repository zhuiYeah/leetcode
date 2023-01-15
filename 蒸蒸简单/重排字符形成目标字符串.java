package 蒸蒸简单;

import java.util.HashMap;
import java.util.Map;

public class 重排字符形成目标字符串 {
    public int rearrangeCharacters(String s, String target) {
        var targetMap = new HashMap<Character, Integer>();
        var map = new HashMap<Character, Integer>();
        for (int i = 0; i < target.length(); i++) {
            targetMap.put(target.charAt(i), targetMap.getOrDefault(target.charAt(i), 0) + 1);
            map.put(target.charAt(i), 0);
        }
        for (int i = 0; i < s.length(); i++) {
            if (targetMap.containsKey(s.charAt(i))) map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int res = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : map.entrySet())
            res = Math.min(res, entry.getValue() / targetMap.get(entry.getKey()));
        return res;
    }
}
