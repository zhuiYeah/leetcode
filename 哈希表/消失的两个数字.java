package 哈希表;

import java.util.HashSet;
import java.util.Set;

public class 消失的两个数字 {
    public int[] missingTwo(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 1; i <= n + 2; i++) {
            set.add(i);
        }
        for (int num : nums) {
            set.remove(num);
        }
        int[] res = new int[2];
        int ptr = 0;
        for (int num : set){
            res[ptr] = num;
            ptr++;
        }
        return res;
    }
}
