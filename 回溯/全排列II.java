package 回溯;

import java.util.*;

public class 全排列II {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int n;
    boolean[] used;
    int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        n = nums.length;
        this.nums = nums;
        used = new boolean[n];
        //Arrays.sort(nums);
        backtracking();
        return  res;
    }

    public void backtracking() {
        if (path.size() == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!set.contains(nums[i]) && !used[i]) {
                set.add(nums[i]);
                used[i]= true;
                path.add(nums[i]);
                backtracking();
                path.remove(path.size() - 1);
                used[i]= false;
            }
        }
    }
}
