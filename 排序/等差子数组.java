package 排序;

import java.util.ArrayList;
import java.util.List;

public class 等差子数组 {
    int[] nums;

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        this.nums = nums;
        List<Boolean> result = new ArrayList<Boolean>();
        for (int i = 0; i < l.length; i++) {
            result.add(canDengCha(l[i], r[i]));
        }
        return result;
    }

    public boolean canDengCha(int l, int r) {
        if (r - l == 1) return true;
        var list = new ArrayList<Integer>();
        for (int i = l; i <= r; i++) {
            list.add(nums[i]);
        }
        list.sort((a, b) -> {
            return a - b;
        });
        int diff = list.get(1) - list.get(0);
        for (int i = 2; i < list.size(); i++) {
            if (list.get(i) - list.get(i - 1) != diff) return false;
        }
        return true;
    }
}
