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
            backtracking(i);
            path.remove(path.size() - 1);
        }
    }
}

//剑指offer
class dede {
    List<List<Integer>> res;
    List<Integer> path;
    int n;
    int[] NUMS;

    public List<List<Integer>> subsets(int[] nums) {
        NUMS = nums;
        n = nums.length;
        res = new ArrayList<>();
        path = new ArrayList<>();
        backtracking(0);
        return res;
    }

    private void backtracking(int index) {
        if (index == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(NUMS[index]);
        backtracking(index + 1);
        path.remove(path.size() - 1);
        backtracking(index + 1);
    }
}
