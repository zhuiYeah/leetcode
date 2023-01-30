package 链蒸蒸简单;

import java.util.HashSet;

public class 字符串中不同整数的数目 {
    public int numDifferentIntegers(String word) {
        var set = new HashSet<String>();
        int n = word.length(), i = 0;
        while (i < n) {
            var c = word.charAt(i);
            if (c == '0' && (i + 1 == n || word.charAt(i + 1) < '0' || word.charAt(i + 1) > '9')) {
                set.add("0");
                i++;
                continue;
            }
            if (c >= '1' && c <= '9') {
                var start = i;
                while (i < n && word.charAt(i) >= '0' && word.charAt(i) <= '9') i++;
                set.add(word.substring(start, i));
            } else {
                i++;
            }
        }

        return set.size();
    }
}
