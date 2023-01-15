package 蒸蒸简单;

import java.util.HashMap;
import java.util.List;

//字符串 + 哈希表
public class 替换字符串中的括号内容 {
    public String evaluate(String s, List<List<String>> knowledge) {
        var res = new StringBuilder();
        var map = new HashMap<String, String>();
        for (List<String> x : knowledge)
            map.put(x.get(0), x.get(1));
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '(') {
                int l = i + 1;
                while (s.charAt(i) != ')') i++;
                int r = i;
                String key = s.substring(l, r);
                String value = map.getOrDefault(key, "?");
                res.append(value);
            } else {
                res.append(c);
            }
            i++;
        }
        return res.toString();
    }
}
