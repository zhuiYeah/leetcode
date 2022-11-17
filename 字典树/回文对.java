package 字典树;

import java.util.*;


class 回文对2 {
    List<String> wordsRev = new ArrayList<String>();
    Map<String, Integer> indices = new HashMap<String, Integer>();

    public List<List<Integer>> palindromePairs(String[] words) {
        int n = words.length;
        for (String word : words) {
            wordsRev.add(new StringBuffer(word).reverse().toString());
        }
        for (int i = 0; i < n; ++i) {
            indices.put(wordsRev.get(i), i);
        }

        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            String word = words[i];
            int m = words[i].length();
            if (m == 0) {
                continue;
            }
            for (int j = 0; j <= m; j++) {
                if (isPalindrome(word, j, m - 1)) {
                    int leftId = findWord(word, 0, j - 1);
                    if (leftId != -1 && leftId != i) {
                        ret.add(Arrays.asList(i, leftId));
                    }
                }
                if (j != 0 && isPalindrome(word, 0, j - 1)) {
                    int rightId = findWord(word, j, m - 1);
                    if (rightId != -1 && rightId != i) {
                        ret.add(Arrays.asList(rightId, i));
                    }
                }
            }
        }
        return ret;
    }

    public boolean isPalindrome(String s, int left, int right) {
        int len = right - left + 1;
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(left + i) != s.charAt(right - i)) {
                return false;
            }
        }
        return true;
    }

    public int findWord(String s, int left, int right) {
        return indices.getOrDefault(s.substring(left, right + 1), -1);
    }

}



//135 / 136 超时
public class 回文对 {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        var map = new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) map.put(words[i], i);
        for (int i = 0; i < words.length; i++) {
            var s = reverse(words[i], 0, words[i].length() - 1);
            if (!s.equals(words[i]) && map.containsKey(s)) {
                var list = new ArrayList<Integer>();
                list.add(i);
                list.add(map.get(s));
                res.add(list);
            }
            for (int j = 0; j < words[i].length(); j++) {
                if (isP(words[i], 0, j)) {
                    s = reverse(words[i], j + 1, words[i].length() - 1);
                    if (map.containsKey(s)) {
                        var list = new ArrayList<Integer>();
                        list.add(map.get(s));
                        list.add(i);
                        res.add(list);
                    }
                }
                if (isP(words[i], words[i].length() - 1 - j, words[i].length() - 1)) {
                    s = reverse(words[i], 0, words[i].length() - 1 - j - 1);
                    if (map.containsKey(s)) {
                        var list = new ArrayList<Integer>();
                        list.add(i);
                        list.add(map.get(s));
                        res.add(list);
                    }
                }
            }

        }
        return res;
    }

    private String reverse(String s, int l, int r) {
        var c = new char[r - l + 1];
        for (int i = l; i <= r; i++) {
            c[i - l] = s.charAt(i);
        }
        int n = c.length;
        for (int i = 0; i < c.length / 2; i++) {
            var tmp = c[i];
            c[i] = c[n - 1 - i];
            c[n - 1 - i] = tmp;
        }
        return new String(c);
    }

    private boolean isP(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
