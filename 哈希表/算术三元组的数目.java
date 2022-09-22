package 哈希表;

import java.util.HashSet;

public class 算术三元组的数目 {
    HashSet<Integer> seen = new HashSet<>();
    int res = 0;

    public int arithmeticTriplets(int[] nums, int diff) {
        for (int i = 0; i < nums.length; i++) {
            seen.add(nums[i]);
            if (seen.contains(nums[i] - diff) && seen.contains(nums[i] - diff * 2)) res++;
        }
        return res;
    }
}
