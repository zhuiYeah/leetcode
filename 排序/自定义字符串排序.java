package 排序;

import java.util.Arrays;
import java.util.HashMap;

//自定义排序
public class 自定义字符串排序 {
    public String customSortString(String order, String s) {
        var map = new HashMap<Character, Integer>();
        for (int i = 0; i < order.length(); i++) map.put(order.charAt(i), i + 1);
        char[] c = s.toCharArray();
        Character[] cc = new Character[c.length];
        for (int i = 0; i < cc.length; i++) cc[i] = c[i];
        Arrays.sort(cc, (a, b) -> {
            return map.getOrDefault(a, 0) - map.getOrDefault(b, 0);
        });
        for (int i = 0; i < cc.length; i++) c[i] = cc[i];
        return new String(c);
    }
}
