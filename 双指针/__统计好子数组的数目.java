package 双指针;

import java.util.HashMap;
import java.util.Map;
//周赛第三题   思路错误
/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回 nums 中 好 子数组的数目。
 * 一个子数组 arr 如果有 至少 k 对下标 (i, j) 满足 i < j 且 arr[i] == arr[j] ，那么称它是一个 好 子数组。
 * 计数问题的思路之一是 双指针
 **/


/**计数问题的思路之一是 双指针**/

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

//
//class Solution {
//    public long countGood(int[] nums, int k) {
//        int n = nums.length;
//        long ans = 0;
//        for(int i = 0, r = -1; i < n; i++) {
//            while(current < k && r + 1 < n) {
//                r++;
//                add(nums[r]);
//            }
//            if(current >= k) {
//                ans += n - r;
//            }
//            delete(nums[i]);
//        }
//        return ans;
//    }
//    Map<Integer, Integer> count = new HashMap();
//    long current = 0;
//    void add(int x) {
//        int now = count.getOrDefault(x, 0);
//        current += now;
//        count.put(x, now + 1);
//    }
//    void delete(int x) {
//        int now = count.getOrDefault(x, 0);
//        current -= now - 1;
//        count.put(x, now - 1);
//    }
//}

/**如何确定以r为右边界的满足条件的子数组总数???：
 * 以右边界r指向的右端点为基准，找到能满足条件的l，并使得r-l最小,这样的话 以r为右边界的满足条件的子数组总数为l+1，
 * 枚举所有的r
 * */
class Solution {
    HashMap<Integer, Integer> cnt = new HashMap<>();

    public long countGood(int[] nums, int k) {
        int n = nums.length;
        long res = 0;
        int l = 0, r = 0, pairs = 0;
        for (; r < n; r++) {
            pairs += cnt.getOrDefault(nums[r], 0);
            cnt.put(nums[r], cnt.getOrDefault(nums[r], 0) + 1);
            while (l < r && pairs - cnt.get(nums[l]) + 1 >= k) {
                pairs = pairs - cnt.get(nums[l]) + 1;
                cnt.put(nums[l], cnt.get(nums[l]) - 1);
                l++;
            }
            if (pairs >= k) res += l + 1;
        }
        return res;
    }

}
