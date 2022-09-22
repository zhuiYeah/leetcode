package 哈希表;

import java.util.ArrayList;
import java.util.List;

public class 词频分析_查找共用字符 {
    public List<String> commonChars(String[] words) {
        int[] fre = new int[26];
        for (int i = 0; i < words[0].length(); i++) {
            fre[words[0].charAt(i) - 'a']++;
        }
        for (int i = 1; i < words.length; i++) {
            int[] fre2 = new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                fre2[words[i].charAt(j) - 'a']++;
            }
            for (int k = 0; k < 26; k++) {
                fre[k] = Math.min(fre[k], fre2[k]);
            }
        }
        ArrayList<String> res = new ArrayList<>();
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < fre[k]; i++) {
                //将0～25这些数字表示成26个字母 ： （char）(11+'a')
                res.add(String.valueOf((char) ('a' + k)));
            }
        }
        return res;
    }
}
