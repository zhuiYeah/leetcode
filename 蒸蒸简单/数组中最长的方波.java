package 蒸蒸简单;

import java.util.Arrays;
import java.util.HashSet;

//要找的子序列，它的开头便规定了全部的子序列
//类似题目 ： 最长的斐波那契子序列的长度
public class 数组中最长的方波 {
    public int longestSquareStreak(int[] nums) {
        int n = nums.length;
        var set = new HashSet<Integer>();
        for (int i = 0; i < n; i++) set.add(nums[i]);
        Arrays.sort(nums);
        int res = -1;
        for (int i = 0; i < n; i++) {
            int base = nums[i];
            if (!set.contains(base * base)) continue;
            int cnt = 2;
            base = base * base;
            while (set.contains(base* base)){
                cnt++;
                base = base * base;
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
}
