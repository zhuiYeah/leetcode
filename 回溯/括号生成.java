package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 括号生成 {
    int n;
    List<String> res = new ArrayList<String>();
    StringBuilder path = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        this.n = n;
        backtracking(0,0);
        return res;
    }

    public void backtracking(int left, int right) {
        if (right > left) {
            return;
        }
        if (left > n) return;
        if (left == n && right ==n) {
            res.add(path.toString());
            return;
        }
        path.append('(');
        backtracking(left+1, right);
        path.deleteCharAt(path.length()-1);
        if (path.length()!=0){
            path.append(')');
            backtracking(left, right+1);
            path.deleteCharAt(path.length()-1);
        }
    }
}
