package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 字母大小写全排列 {
    List<String> res;
    int n;
    char[] path;

    public List<String> letterCasePermutation(String s) {
        res = new ArrayList<String>();
        path = s.toCharArray();
        n = s.length();
        backtracking(0);
        return res;
    }

    public void backtracking(int index) {
        while (index < n && path[index] >= '0' && path[index] <= '9') index++;
        if (index == n) {
            res.add(new String(path));
            return;
        }
        char c = path[index];
        if (c >= 'A' && c <= 'Z') {
            c += 32;
        }
        path[index] = c;
        backtracking(index + 1);
        path[index] = (char) (c - 32);
        backtracking(index + 1);
    }
}



//每日一题重温一遍
class xewx {
    List<String> res;
    char[] path;
    int n;

    public List<String> letterCasePermutation(String s) {
        res = new ArrayList<String>();
        path = s.toCharArray();
        n = s.length();
        backtracking(0);
        return res;
    }

    public void backtracking(int index) {
        while (index < n && path[index] >= '0' && path[index] <= '9') index++;
        if (index == n) {
            res.add(new String(path));
            return;
        }
        var tmp = path[index];
        if (tmp >= 'A' && tmp <= 'Z') path[index] += 32;
        backtracking(index + 1);
        path[index] -= 32;
        backtracking(index + 1);
    }
}
