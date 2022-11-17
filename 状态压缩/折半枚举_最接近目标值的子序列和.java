package 状态压缩;

import java.util.Arrays;
import java.util.HashSet;

//状态压缩 + 折半枚举 + 二分查找
public class 折半枚举_最接近目标值的子序列和 {
    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length, m = n / 2, min = Integer.MAX_VALUE;
        var set = new HashSet<Integer>(); //记录左半区间所有可能的和
        //mask唯一标识了对左半区间的一种选择情况
        for (int mask = 0; mask < 1 << m; mask++) {
            int sum = 0;
            for (int i = 0; i < m; i++) {
                if ((mask & (1 << i)) != 0) sum += nums[i];
            }
            set.add(sum);
            if (sum == goal) return 0;
        }
        var leftsum = new int[set.size()];
        int i = 0;
        for (int x : set) {
            leftsum[i] = x;
            i++;
        }
        Arrays.sort(leftsum);
        set.clear();
        for (int mask = 0; mask < 1 << (n - m); mask++) {
            int sumright = 0;
            for (i = m; i < n; i++) {
                if ((mask & (1 << (i - m))) != 0) sumright += nums[i];
            }
            if (set.contains(sumright)) continue;
            set.add(sumright);
            int left = 0, right = leftsum.length - 1, curmin = Integer.MAX_VALUE;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int x = leftsum[mid];
                if (sumright + x - goal > 0) {
                    curmin = Math.min(sumright + x - goal, curmin);
                    right = mid - 1;
                } else if (sumright + x - goal < 0) {
                    curmin = Math.min(curmin, -(sumright + x - goal));
                    left = mid + 1;
                } else {
                    return 0;
                }
            }
            min = Math.min(min, curmin);
        }
        return min;
    }
}

class test1 {
    public static void main(String[] args) {
        var x = new 折半枚举_最接近目标值的子序列和();
        x.minAbsDifference(new int[]{7, -9, 15, -2}, -5);
    }
}
