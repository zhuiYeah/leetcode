package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和II {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] candidates;
    int n, target;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        this.n = candidates.length;
        this.target = target;
        Arrays.sort(candidates);
        backtracking(0,0);
        return res;
    }

    public void backtracking(int curIndex, int curSum) {
        if (curSum > target) return;
        if (curSum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = curIndex; i < n; i++) {
            if (i > curIndex && candidates[i] == candidates[i - 1]) continue;
            path.add(candidates[i]);
            backtracking(i + 1, curSum + candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}
