package 数组;

import java.util.HashSet;

public class 使数组中所有元素都等于零 {
    HashSet<Integer> seen = new HashSet<>();

    public int minimumOperations(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) seen.add(nums[i]);
        }
        return seen.size();
    }
}
