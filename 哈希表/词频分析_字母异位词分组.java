package 哈希表;

import java.util.*;

//将所有的字母异位词分到同一组
public class 词频分析_字母异位词分组 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            var fre = new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                int index = strs[i].charAt(j) - 'a';
                fre[index]++;
            }
            var s = Arrays.toString(fre);
            var allW = map.getOrDefault(s, new ArrayList<String>());
            allW.add(strs[i]);
            map.put(s, allW);
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs);
    }
}


////////////////////////////////////////////////////////////////////////////////////////////////////////////
class d3wedexw{
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();
        for (String str : strs) {
            var charArr = str.toCharArray();
            Arrays.sort(charArr);
            String s = new String(charArr);
            var allW = map.getOrDefault(s, new ArrayList<String>());
            allW.add(str);
            map.put(s, allW);
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
