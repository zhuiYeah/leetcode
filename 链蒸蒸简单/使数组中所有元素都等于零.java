package 链蒸蒸简单;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 使数组中所有元素都等于零 {
    public int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int cnt = 0, ptr = 0;
        while (nums[n - 1] > 0) {
            while (ptr < n && nums[ptr] == 0) ptr++;
            int x = nums[ptr];
            for (int i = ptr; i < n; i++) nums[i] -= x;
            cnt++;
        }
        return cnt;
    }
}

class dewfc {
    public static void main(String[] args) {
        new 使数组中所有元素都等于零().minimumOperations(new int[]{1, 5, 0, 3, 5});
    }
}
