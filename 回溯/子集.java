package 回溯;

import java.util.ArrayList;
import java.util.List;

public class 子集 {
    List<List<Integer>> result = new ArrayList<>();
    int n;
    int[] nums;
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        result.add(new ArrayList<>());
        n = nums.length;
        this.nums = nums;
        backtracking(-1);
        return result;
    }

    public void backtracking(int curIndex) {
        if (curIndex >= n) return;
        if (curIndex != -1) {
            path.add(nums[curIndex]);
            result.add(new ArrayList<>(path));
        }

        for (int i = curIndex + 1; i < n; i++) {
            backtracking(i );
            path.remove(path.size() - 1);
        }
    }
}
