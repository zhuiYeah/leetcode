package 模拟;

import java.util.ArrayList;
import java.util.List;

public class 驼峰式匹配 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        var res = new ArrayList<Boolean>();
        for (String q : queries) {
            if (compare(q, pattern)) res.add(true);
            else res.add(false);
        }
        return res;
    }

    private boolean compare(String s, String pattern) {
        int n = pattern.length();
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z' && p == n) return false;
            if (c >= 'A' && c <= 'Z') {
                if (c == pattern.charAt(p)) p++;
                else return false;
            }
            if (c >= 'a' && c <= 'z' && p < n && c == pattern.charAt(p)) {
                p++;
            }
        }
        return p == n;
    }
}
