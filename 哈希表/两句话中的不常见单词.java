package 哈希表;

import 二叉树.TreeNode;

import java.util.*;

public class 两句话中的不常见单词 {
    ArrayList<String> list = new ArrayList<>();
    int start = 0;
    int end;
    HashMap<String, Integer> map = new HashMap<>();

    public String[] uncommonFromSentences(String s1, String s2) {
        String s = s1 + " " + s2 + " ";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                end = i;
                String sub = s.substring(start, end);
                map.put(sub, map.getOrDefault(sub, 0) + 1);
                start = i + 1;
            }
        }
        for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        String[] res = new String[list.size()];
        return list.toArray(res);
    }
}

