package 链蒸蒸简单;

import java.util.HashMap;

public class 解密消息 {
    public String decodeMessage(String key, String message) {
        int flag = 0;
        var map = new HashMap<Character, Character>();
        map.put(' ', ' ');
        var sb = new StringBuilder();
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (c == ' ') continue;
            if (!map.containsKey(c)) {
                map.put(c, (char) ('a' + flag));
                flag++;
            }
        }
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            c = map.get(c);
            sb.append(c);
        }
        return sb.toString();
    }
}
