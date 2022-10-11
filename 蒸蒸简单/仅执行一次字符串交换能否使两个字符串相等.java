package 蒸蒸简单;

import java.util.HashSet;

public class 仅执行一次字符串交换能否使两个字符串相等 {
    public boolean areAlmostEqual(String s1, String s2) {
        int count = 0;
        char x1 = 0;
        char x2 = 0;
        char y1 = 0;
        char y2 = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count == 1) {
                    x1 = s1.charAt(i);
                    y1 = s2.charAt(i);
                } else if (count == 2) {
                    x2 = s1.charAt(i);
                    y2 = s2.charAt(i);
                }
            }
            if (count > 2) return false;
        }
        if (count == 0) return true;
        if (count == 1) return false;
        return x1 == y2 && y1 == x2;
    }
}
