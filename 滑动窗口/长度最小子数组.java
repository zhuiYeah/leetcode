package 滑动窗口;


import java.util.Arrays;
import java.util.TreeMap;

//找到和大于target的长度最小的子数组的长度
//没写出来 这是错误的
public class 长度最小子数组 {
    public static int minSubArrayLen(int target, int[] nums) {
        if (Arrays.stream(nums).sum() < target) {
            return 0;
        }
        // 前缀和 -》 能达到该前缀和的最近(大)下标
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        map.put(0, -1);
        map.put(nums[0], 0);
        if (nums[0] == target) return 1;
        int min = nums.length;
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];

            if (map.ceilingEntry(nums[i] - target) != null) {
                min = Math.min(min, i - map.ceilingEntry(nums[i] - target).getValue());
            }
            map.put(nums[i], i);
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println("2");
        minSubArrayLen(4, new int[]{1, 1, 1});
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
//还得是滑动窗口
class fdedee {
    public static int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0;
        int sum = 0, min = Integer.MAX_VALUE;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= target) {
                min = Math.min(min, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
