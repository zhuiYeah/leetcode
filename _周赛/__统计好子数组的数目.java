package _周赛;

import java.util.HashMap;
import java.util.Map;

//public class 统计好子数组的数目 {
//    public long countGood(int[] nums, int k) {
//        int n = nums.length;
//        long cnt = 0;
//        int quan = 0;
//        int l = 0, r = 0;
//        var map = new HashMap<Integer, Integer>();
//        while (r < n) {
//            while (r < n && quan < k) {
//                map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
//                quan += map.get(nums[r])-1;
//                r++;
//            }
//
//
//        }
//
//    }
//}


class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        long ans = 0;
        for(int i = 0, r = -1; i < n; i++) {
            while(current < k && r + 1 < n) {
                r++;
                add(nums[r]);
            }
            if(current >= k) {
                ans += n - r;
            }
            delete(nums[i]);
        }
        return ans;
    }
    Map<Integer, Integer> count = new HashMap();
    long current = 0;
    void add(int x) {
        int now = count.getOrDefault(x, 0);
        current += now;
        count.put(x, now + 1);
    }
    void delete(int x) {
        int now = count.getOrDefault(x, 0);
        current -= now - 1;
        count.put(x, now - 1);
    }
}
