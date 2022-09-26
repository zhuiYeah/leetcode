package 周赛;

import java.util.ArrayList;
import java.util.List;

//65/66 无语
public class _找到所有的好下标 {
    int[] nums;

    public List<Integer> goodIndices(int[] nums, int k) {
        var res = new ArrayList<Integer>();
        this.nums = nums;
        int n = nums.length;
        int left = 0, right = 2 * k;
        for (left = 0; left <= n - 1 - 2 * k; left++, right++) {
            if (isValid(left, right)) {
                res.add(left + k);
            }
        }
        return res;
    }

    public boolean isValid(int left, int right) {
        int mid = left + (right - left) / 2;
        for (int i = left + 1; i <= mid - 1; i++) {
            if (nums[i] - nums[i - 1] > 0) return false;
            if (nums[i + 1 + (right - left) / 2] - nums[i + (right - left) / 2] < 0) return false;
        }
        return true;
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
//周赛的时候咋也没想到动态规划 没办法呀
//没能想到动态规划，记录当前位置的 向前的连续递增长度 和 向后的连续递减长度
class dededew {
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n], right = new int[n];
        //left[i] : 以nums[i]为结尾的最大连续递减的个数
        //right[i] : 以nums[i]为结尾的最大连续递增的个数
        left[0] = 1;
        right[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }
        var res = new ArrayList<Integer>();
        for (int i = k; i < n - k; i++) {
            if (left[i - 1] >= k && right[i + 1] >= k) {
                res.add(i);
            }
        }
        return res;
    }
}
