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
        return res;
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
                used[i] = true;
                path.add(nums[i]);
                backtracking();
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }
}

//剑指offer
class frefre {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int n;
    int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        n = nums.length;
        this.nums = nums;
        backtracking();
        return res;
    }

    private void backtracking() {
        if (path.size() == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        var set = new HashSet<Integer>(); //记录本层已经选择过的元素
        for (int i = 0; i < n; i++) {
            if (nums[i] == 114514) continue;//已经被之前的层选过
            if (set.contains(nums[i])) continue; //本层已经选过相同值的数字
            set.add(nums[i]);
            path.add(nums[i]);
            nums[i] = 114514;
            backtracking();
            nums[i] = path.get(path.size() - 1);
            path.remove(path.size() - 1);
        }
    }
}
