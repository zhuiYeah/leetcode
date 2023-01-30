package 链蒸蒸简单;

import java.util.ArrayList;
import java.util.List;

public class 距离字典两次编辑以内的单词 {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<String>();
        for (String word : queries) {
            for (String target : dictionary) {
                if (isok(word, target)) {
                    res.add(word);
                    break;
                }
            }
        }
        return res;
    }

    public boolean isok(String s1, String s2) {
        int count = 0;
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) count++;
            if (count > 2) return false;
        }
        return true;
    }
}
