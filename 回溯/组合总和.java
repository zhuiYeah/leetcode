package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 组合总和 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int n;
    int target;
    int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        n = candidates.length;
        this.candidates = candidates;
        this.target = target;
        Arrays.sort(candidates);
        backtracking(0, 0);
        return res;
    }

    public void backtracking(int curIndex, int curSum) {
        //if (curIndex >= n) return;
        if (curSum > target) return;
        if (curSum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = curIndex; i < n; i++) {
            path.add(candidates[i]);
            backtracking(i, curSum + candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}

//剑指offer
class edede {
    int[] candidates;
    int target;
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        Arrays.sort(candidates);
        backtracking(0, 0);
        return res;
    }

    private void backtracking(int idx, int curSum) {
        if (curSum > target) return;
        if (curSum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (idx == candidates.length) return;
        for (int i = idx; i < candidates.length; i++) {
            path.add(candidates[i]);
            backtracking(i, curSum + candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}
