package 前缀和;

/**
 * 给你一个数组nums 和 一个整数p
 * <p>
 * 删除数组的一个子数组 ， 使得数组的和能被p整除
 * <p>
 * 求出 子数组的最短长度
 */

import java.util.HashMap;

/**
 * 前缀和 + hashmap + 数学
 */
public class ___使数组和能被P整除 {
    public int minSubarray(int[] nums, int p) {
        if (p == 1) return 0;
        long x = 0L;//数组的和
        int n = nums.length;
        for (int i : nums) x += i;
        int target = (int) (x % p);
        if (target == 0) return 0;
        //现在就要找到一个最短子数组，子数组的和 %p 为 target
        long s[] = new long[n + 1]; //前缀和数组
        for (int i = 1; i <= n; i++) s[i] = s[i - 1] + nums[i - 1];
        //子数组 [i,j]的和 等于 s[j+1] - s[i]
        //即 如果 （s[right] - s[left] ）% p == target ,那么 满足条件的子数组长度为right-left
        var map = new HashMap<Integer, Integer>();
        //如果 (s[r]%p - target + p)% p == s[l]%p ，那么 r-l就是一个数组的长度
        //枚举所有的r，记录之前的l到哈希表中
        var res = n;
        for (int r = 0; r < n + 1; r++) {
            int xx = (int) ((s[r] % p - target + p) % p);
            if (map.containsKey(xx)) {
                int l = map.get(xx);
                res = Math.min(res, r - l);
            }
            map.put((int) (s[r] % p), r);
        }
        return res == n ? -1 : res;
    }
}
