package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 分割回文串 {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    String S;
    int n;

    public List<List<String>> partition(String s) {
        S = s;
        n = S.length();
        backtracking(1, 0);
        var resres = new String[res.size()][];
//        for (int i = 0; i < resres.length; i++) {
//            resres[i] = new String[res.get(i).size()];
//            for (int j = 0; j < resres[i].length; j++) {
//                resres[i][j] = res.get(i).get(j);
//            }
//        }
//        return resres;
        return res;
    }

    //当前在cur位置，前一个切割位置（左）是pre
    private void backtracking(int cur, int pre) {
        if (cur == n) { //边界
            if (isP(pre, cur)) {
                path.add(S.substring(pre, cur));
                res.add(new ArrayList<>(path));
                path.remove(path.size() - 1);
            }
            return;
        }
        //cur位置（左）只有两种情况，切割或不切割
        if (isP(pre, cur)) {
            path.add(S.substring(pre, cur));
            backtracking(cur + 1, cur);
            path.remove(path.size() - 1);
        }
        backtracking(cur + 1, pre);
    }

    private boolean isP(int l, int r) {
        while (l < r - 1) {
            if (S.charAt(l) != S.charAt(r - 1)) return false;
            l++;
            r--;
        }
        return true;
    }
}


