package 链蒸蒸简单;

import java.util.HashSet;

public class 判断字符串的两半是否相似 {
    public boolean halvesAreAlike(String s) {
        var set = new HashSet<Character>();
        set.add('a');
        set.add('o');
        set.add('e');
        set.add('i');
        set.add('u');
        set.add('A');
        set.add('O');
        set.add('E');
        set.add('I');
        set.add('U');
        int n = s.length();
        int c1 = 0, c2 = 0;
        for (int i = 0; i < n / 2; i++) if (set.contains(s.charAt(i))) c1++;
        for (int i = n / 2; i < n; i++) if (set.contains(s.charAt(i))) c2++;
        return c1 == c2;
    }
}
