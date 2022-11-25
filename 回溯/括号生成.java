package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 括号生成 {
    int n;
    List<String> res = new ArrayList<String>();
    StringBuilder path = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        this.n = n;
        backtracking(0, 0);
        return res;
    }

    public void backtracking(int left, int right) {
        if (right > left) {
            return;
        }
        if (left > n) return;
        if (left == n && right == n) {
            res.add(path.toString());
            return;
        }
        path.append('(');
        backtracking(left + 1, right);
        path.deleteCharAt(path.length() - 1);
        if (path.length() != 0) {
            path.append(')');
            backtracking(left, right + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}

//剑指offer
class dedede {
    List<String> res = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    int N;

    public List<String> generateParenthesis(int n) {
        N = n;
        backtracking(0, 0);
        return res;
    }

    private void backtracking(int ln, int rn) {
        if (ln > N || rn > N) return;
        if (rn > ln) return;
        if (ln == rn && ln == N) {
            res.add(path.toString());
            return;
        }
        path.append('(');
        backtracking(ln + 1, rn);
        path.deleteCharAt(path.length() - 1);
        path.append(')');
        backtracking(ln, rn + 1);
        path.deleteCharAt(path.length() - 1);
    }
}
