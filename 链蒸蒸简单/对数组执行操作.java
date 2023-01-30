package 链蒸蒸简单;

import java.util.ArrayList;

//来自318场周赛
public class 对数组执行操作 {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] = 2 * nums[i];
                nums[i + 1] = 0;
            }
        }
        var arr = new ArrayList<Integer>();
        for (int j : nums) arr.add(j);
        for (int i = 0, count = 0; i < nums.length; i++, count++) {
            if (count > 2000) break;
            if (arr.get(i) == 0) {
                arr.remove(i);
                arr.add(0);
                i--;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr.get(i);
        }
        return nums;
    }
}
