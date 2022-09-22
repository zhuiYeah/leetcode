package 字符串;

import java.util.HashSet;
import java.util.Set;

public class 山羊拉丁文 {
    int start = 0;
    int end;
    String res = "";
    Set<Character> vowels = new HashSet<Character>() {{
        add('a');
        add('e');
        add('i');
        add('o');
        add('u');
        add('A');
        add('E');
        add('I');
        add('O');
        add('U');
    }};
    String extra = "a ";

    public String toGoatLatin(String sentence) {
        sentence += " ";
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                end = i;
                StringBuilder sub = new StringBuilder(sentence.substring(start, end));
                start = i + 1;
                if (vowels.contains(sub.charAt(0))) {
                    sub.append("ma");
                } else {
                    sub = new StringBuilder(sub.substring(1) + sub.charAt(0) + "ma");
                }
                sub.append(extra);
                extra = "a" + extra;
                res += sub;
            }
        }
        return res.substring(0, res.length() - 1);
    }

}
