package 数学;

import java.util.Arrays;

//中位数贪心
public class 最小操作次数使数组元素相等II_中位数 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int target = nums[n/2];
        int cost = 0;
        for (int num : nums) {
            cost += Math.abs(target - num);
        }
        return cost;
    }
}
