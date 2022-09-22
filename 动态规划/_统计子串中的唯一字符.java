package 动态规划;

import java.util.Arrays;
import java.util.HashMap;

public class _统计子串中的唯一字符 {
    public int uniqueLetterString(String s) {
        int n = s.length();
        int[] dpBefore = new int[n];
        int[] dpAfter = new int[n];
        Arrays.fill(dpBefore, -1);
        Arrays.fill(dpAfter, n);
        //dpBefore[i]: 与第i个字符相同的最近的前面一个字符的位置为dpBefore[i]:
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                dpBefore[i] = map.get(s.charAt(i));
            }
            map.put(s.charAt(i), i);
        }
        map.clear();
        for (int i = n - 1; i >= 0; i--) {
            if (map.containsKey(s.charAt(i))) {
                dpAfter[i] = map.get(s.charAt(i));
            }
            map.put(s.charAt(i), i);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += (i - dpBefore[i]) * ( dpAfter[i] - i);
        }
        return res;
    }
}
