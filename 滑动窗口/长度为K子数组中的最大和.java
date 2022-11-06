package 滑动窗口;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//来自318场周赛
public class 长度为K子数组中的最大和 {
    public long maximumSubarraySum(int[] nums, int k) {
        long res = 0;
        //记录滑动窗口中的 数字->其出现次数
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //记录无效数字（滑动窗口中的重复数字）
        Set<Integer> invalid = new HashSet<Integer>();
        long sum = 0;
        for (int i = 0; i < k - 1; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) != 1) invalid.add(nums[i]);
            sum += nums[i];
        }
        for (int left = 0, right = k - 1; right < nums.length; right++, left++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            if (map.get(nums[right]) != 1) invalid.add(nums[right]);
            sum += nums[right];
            //至此已经构成长为k的窗口了
            if (invalid.size() == 0) res = Math.max(sum, res);
            //删除最左边的
            sum -= nums[left];
            var fre = map.get(nums[left]);
            if (fre == 1) {
                map.remove(nums[left]);
            } else if (fre == 2) {
                map.put(nums[left], 1);
                invalid.remove(nums[left]);
            } else {
                map.put(nums[left], fre - 1);
            }
        }
        return res;
    }
}
