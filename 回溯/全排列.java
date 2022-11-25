package 回溯;

import java.util.ArrayList;
import java.util.List;

//剑指offer
public class 全排列 {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<>();
    int[] nums;
    int n;


    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        n = nums.length;
        backtracking();
        return res;
    }

    //backtracking的每一层选择一个未选过的数字并进入下一层，回来后撤销该数字的选择状态并按数组顺序选择下一个数字
    private void backtracking() {
        if (path.size() == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == 11) continue;
            path.add(nums[i]);
            nums[i] = 11;
            backtracking();
            nums[i] = path.get(path.size() - 1);
            path.remove(path.size() - 1);
        }
    }
}
