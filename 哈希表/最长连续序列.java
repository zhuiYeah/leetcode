package 哈希表;

import java.util.HashMap;
import java.util.HashSet;

//5,2,1,4,100,3 ,最长连续序列的长度为5；

public class 最长连续序列 {
    class Solution {
        public int longestConsecutive(int[] nums) {
            int max = 0;
            var map = new HashMap<Integer, Integer>();
            var used = new HashSet<Integer>();
            for (int i = 0; i < nums.length; i++) {
                if (used.contains(nums[i])) continue;
                used.add(nums[i]);
                if (map.containsKey(nums[i] - 1) && map.containsKey(nums[i] + 1)) {
                    int start = map.get(nums[i] - 1);
                    int end = map.get(nums[i] + 1);
                    map.remove(nums[i] - 1);
                    map.remove(nums[i] + 1);
                    map.remove(start);
                    map.remove(end);
                    map.put(start, end);
                    map.put(end, start);
                    max = Math.max(end - start + 1, max);
                } else if (map.containsKey(nums[i] - 1) && !map.containsKey(nums[i] + 1)) {
                    int start = map.get(nums[i] - 1);
                    map.remove(nums[i] - 1);
                    map.remove(start);
                    map.put(start, nums[i]);
                    map.put(nums[i], start);
                    max = Math.max(nums[i] - start + 1, max);
                } else if (!map.containsKey(nums[i] - 1) && map.containsKey(nums[i] + 1)) {
                    int end = map.get(nums[i] + 1);
                    map.remove(nums[i] + 1);
                    map.remove(end);
                    map.put(nums[i], end);
                    map.put(end, nums[i]);
                    max = Math.max(end - nums[i] + 1, max);
                } else {
                    map.put(nums[i], nums[i]);
                    max = Math.max(1,max);
                }
            }
            return max;
        }
    }
}
