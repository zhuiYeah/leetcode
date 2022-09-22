package 哈希表;

import java.util.HashSet;
import java.util.Set;

public class 唯一的摩尔斯密码词 {
    static final String[] CodeTable = {".-", "-...", "-.-.", "-." +
            ".", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--."
            , "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
    HashSet<String> set = new HashSet<String>();

    public int uniqueMorseRepresentations(String[] words) {
        for (int i = 0; i < words.length; i++) {
            String x = "";
            for (int j = 0; j < words[i].length(); j++) {
                x += CodeTable[words[i].charAt(j) - 'a'];
            }
            set.add(x);
        }
        return set.size();
    }
}
