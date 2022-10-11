package 回溯;

import java.util.HashSet;
import java.util.Set;

public class 拆分字符串使得唯一子字符串的数目最大 {
    int max = 1;
    String S;
    Set<String> exist = new HashSet<String>();

    public int maxUniqueSplit(String s) {
        S = s;
        backtracking(0);
        return max;
    }

    //从下标为index开始的位置进行切割
    public void backtracking(int index) {
        if (index == S.length()) return;
        //剪枝
        if (exist.size() + S.length() - index <= max) return;
        //end作为切割的终点
        for (int end = index + 1; end <= S.length(); end++) {
            String next = S.substring(index, end);
            if (!exist.contains(next)) {
                exist.add(next);
                max = Math.max(max, exist.size());
                backtracking(end);
                exist.remove(next);
            }
        }
    }
}
