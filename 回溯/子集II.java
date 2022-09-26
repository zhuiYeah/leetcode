package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 子集II {
    List<List<Integer>> res = new ArrayList<>();
    int n;
    int[] nums;
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        n = nums.length;
        res.add(new ArrayList<>());
        backtracking(0);
        return res;
    }

    private void backtracking(int curIndex) {
        if (curIndex >= n) return;
        for (int i = curIndex; i < n; i++) {
            if (i > curIndex && nums[i] == nums[i - 1]) continue;
            path.add(nums[i]);
            res.add(new ArrayList<>(path));
            backtracking(i+1);
            path.remove(path.size() - 1);
        }
    }
}
