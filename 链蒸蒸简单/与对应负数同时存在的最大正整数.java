package 链蒸蒸简单;

import java.util.HashSet;
import java.util.Set;
//315场周赛
public class 与对应负数同时存在的最大正整数 {
    public int findMaxK(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if (num < 0) set.add(num);
        }
        int max = -1;
        for (int num : nums) {
            if (num > 0) {
                if (set.contains(-num)) {
                    max = Math.max(max, num);
                }
            }
        }
        return max;
    }
}
