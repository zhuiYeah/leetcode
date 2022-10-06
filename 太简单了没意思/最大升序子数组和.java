package 太简单了没意思;

import java.util.Map;

public class 最大升序子数组和 {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int cur = nums[0];
        int max = nums[0] ;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i-1]) {
                cur += nums[i];
            }else{
                cur = nums[i];
            }
            max = Math.max(max,cur);
        }
        return max;
    }
}
