package 回溯;

import java.util.ArrayList;
import java.util.List;


//剑指offer
public class 组合 {
    List<List<Integer>> res;
    List<Integer> path;
    int N, K;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        N = n;
        K = k;
        backtracking(1);
        return res;
    }

    private void backtracking(int cur) {
        if (path.size() == K) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (cur == N + 1) return;
        if (N - cur + 1 < K - path.size()) return;
        path.add(cur);
        backtracking(cur + 1);
        path.remove(path.size() - 1);
        backtracking(cur + 1);
    }
}
