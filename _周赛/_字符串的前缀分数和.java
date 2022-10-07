package _周赛;

import java.util.HashMap;

//字典树
// 哈希表会超时
public class _字符串的前缀分数和 {
    public int[] sumPrefixScores(String[] words) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            for (int i = 1; i <= word.length(); i++) {
                var s = word.substring(0, i);
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        int[] result = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int sum = 0;
            for (int j = 1; j <= words[i].length(); j++) {
                sum += map.get(words[i].substring(0, j));
            }
            result[i] = sum;
        }
        return result;
    }
}
