package 哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//s的子串中 所有 与p 为字母异位词的子串的下标
//也算是滑动窗口吧
public class 词频分析_找到字符串中的所有字母异位词 {
    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<Integer>();
        int n = p.length();
        if (s.length() < n) return result;
        int[] sFre = new int[26];
        int[] pFre = new int[26];
        for (int i = 0; i < n - 1; i++) {
            sFre[s.charAt(i) - 'a']++;
            pFre[p.charAt(i) - 'a']++;
        }
        int left = 0;
        pFre[p.charAt(n - 1) - 'a']++;
        for (int i = n - 1; i < s.length(); i++) {
            sFre[s.charAt(i) - 'a']++;
            if (Arrays.equals(sFre, pFre)) result.add(left);
            sFre[s.charAt(left) - 'a']--;
            left++;
        }
        return result;
    }

    public static void main(String[] args) {
        int a = 0;
        findAnagrams("aa", "bb");
    }
}
