package 字符串;

import java.util.HashMap;
import java.util.Map;

//必须要删除一个字符，使得所有字符出现的次数相同，给定的字符串能满足这个条件吗
//88场双周赛  差点没写出来
public class 删除字符使频率相同 {
    int[] fre = new int[26];

    public boolean equalFrequency(String word) {
        for (int i = 0; i < word.length(); i++) {
            fre[word.charAt(i) - 'a']++;
        }
        //映射频率   -》 该频率的字母有多少个
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < 26; i++) {
            if (fre[i] == 0) continue;
            map.put(fre[i], map.getOrDefault(fre[i], 0) + 1);
        }
        if (map.size() == 1) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                //这里差点没写的出来
                return entry.getKey() == 1 || entry.getValue() == 1;
            }
        }
        if (map.size() == 2) {
            int pre = -1;
            int preFre = 0;
            int now = 0;
            int nowFre = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (pre == -1) {
                    pre = entry.getValue();
                    preFre = entry.getKey();
                } else {
                    now = entry.getValue();
                    nowFre = entry.getKey();
                }
            }
            if (preFre == 1) {
                if (pre == 1) return true;
            }
            if (nowFre == 1) {
                if (now == 1) return true;
            }
            if (nowFre - preFre == 1 && now == 1) return true;
            if (preFre - nowFre == 1 && pre == 1) return true;
        }
        return false;
    }
}
