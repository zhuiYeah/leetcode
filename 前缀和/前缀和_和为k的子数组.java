package 前缀和;

import java.util.HashMap;
import java.util.Map;

//前缀和
//前缀和也是一种动态规划
//前缀和经常用于连续子数组的问题

//9。22第一次做这道题
//和为k的连续子数组一共有多少个
public class 前缀和_和为k的子数组 {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        // 某个前缀和 -》该前缀和出现次数
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        map.put(nums[0], map.getOrDefault(nums[0], 0) + 1);
        if (nums[0] == k) res++;
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
            res += map.getOrDefault(nums[i] - k, 0);

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return res;
    }
}
