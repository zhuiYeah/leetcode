package 回溯;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 电话号码的字母组合 {
    Map<Character, char[]> map = new HashMap<>();
    int n;
    String digits;
    ArrayList<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        n = digits.length();
        this.digits = digits;
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        if (n == 0) return res;
        backtracking(0);
        return res;
    }

    public void backtracking(int curIndex) {
        if (curIndex == n) {
            res.add(sb.toString());
            return;
        }
        char num = digits.charAt(curIndex);
        for (var dd : map.get(num)) {
            sb.append(dd);
            backtracking(curIndex + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
