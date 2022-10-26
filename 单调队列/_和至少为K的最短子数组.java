package 单调队列;


import java.util.ArrayDeque;

//单调队列 + 前缀和
class dwedewdewed {
    public static int shortestSubarray(int[] nums, int k) {
        int n = nums.length, res = n + 1;
        var s = new long[n + 1]; //前缀和数组
        s[0] = 0;
        for (int i = 1; i < n + 1; i++) s[i] = s[i - 1] + nums[i - 1];
        //现在问题变为找到使得s[i] - s[j] >=k (i>j) 的（i-j）的最小值
        var queue = new ArrayDeque<Integer>();
        for (int i = 0; i < s.length; i++) {
            var curS = s[i];
            //如果 s[i] - s[队列头] >=k ，那么 i-队列头 达到了一个局部最小值 。后面i递增，如果再取队列头的话，必然 大于 i-队列头 ，于是队列头再也不会被作为左端点，弹出队列头。
            while (!queue.isEmpty() && curS - s[queue.peekFirst()] >= k) res = Math.min(res, i - queue.pollFirst());
            //s[i]<=s[队列尾]。那么 对于后面的任何一个满足 s[x] - s[队列尾] >= k的 x ， s[x] - s[i]也 必然大于等于k,且x-i要小于x-队列尾，那么队列尾巴再也没用了，弹出。
            while (!queue.isEmpty() && curS <= s[queue.peekLast()]) queue.pollLast();
            queue.add(i);
        }
        return res == n + 1 ? -1 : res;
    }
}


//滑动窗口能过 58/97个 ,存在负数，无法滑动窗口
public class _和至少为K的最短子数组 {
    public static int shortestSubarray(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        int left = 0, right = 0;
        int sum = 0;
        while (right < n) {
            while (sum < k && right < n) {
                sum += nums[right];
                right++;
            }
            if (right == n && sum < k) break;
            min = Math.min(min, right - left);
            sum -= nums[left];
            left++;
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        var nums = new int[]{84, -37, 32, 40, 95};
        shortestSubarray(nums, 167);
    }
}

//暴力枚举 ,85 / 97 个通过的测试用例 时间复杂度O（n^2） n最大为 10^5
class dewdewd {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int min = n + 1;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= k && j - i + 1 <= min) {
                    min = j - i + 1;
                    break;
                }
                if (j - i + 1 > min) break;
            }
        }
        return min == n + 1 ? -1 : min;
    }
}
