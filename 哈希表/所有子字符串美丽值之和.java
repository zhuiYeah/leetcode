package 哈希表;

import java.util.HashMap;
import java.util.Map;

//枚举全部子字符串
public class 所有子字符串美丽值之和 {
    public int beautySum(String s) {
        var map = new HashMap<Character, Integer>();
        int n = s.length();
        int max = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            //i作为开头
            map.clear();
            max = 0;
            for (int j = i; j < n; j++) {
                var c = s.charAt(j);
                map.put(c, map.getOrDefault(c, 0) + 1);
                max = Math.max(max, map.get(c));
                if (map.size() >= 2) {
//                    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//                        min = Math.min(min, entry.getValue());
//                    }
                    int min = map.values().stream().min(Integer::compare).get();
                    res += max - min;
                }
            }
        }
        return res;
    }
}

class dede {
    public static void main(String[] args) {
        new 所有子字符串美丽值之和().beautySum("aab");
    }
}


//只包含小写字母 -》利用数组优化，数组模拟哈希表
class dedede {
    public int beautySum(String s) {
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int[] cnt = new int[26];
            int max = 0;
            for (int j = i; j < n; j++) {
                var idx = s.charAt(j) - 'a';
                cnt[idx]++;
                max = Math.max(max, cnt[idx]);
                int min = 500;
                for (int fre : cnt) {
                    if (fre > 0) {
                        min = Math.min(min, fre);
                    }
                }
                res += max - min;
            }

        }
        return res;
    }
}
