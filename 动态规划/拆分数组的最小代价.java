package 动态规划;

import java.util.*;

/**
 * 给你一个整数数组 nums 和一个整数 k 。
 * <p>
 * 将数组拆分成一些非空子数组。拆分的 代价 是每个子数组中的 重要性 之和。
 * <p>
 * 令 trimmed(subarray) 作为子数组的一个特征，其中所有仅出现一次的数字将会被移除。
 * <p>
 * 例如，trimmed([3,1,2,4,3,4]) = [3,4,3,4] 。
 * 子数组的 重要性 定义为 k + trimmed(subarray).length 。
 * <p>
 * 例如，如果一个子数组是 [1,2,3,3,3,4,4] ，trimmed([1,2,3,3,3,4,4]) = [3,3,3,4,4] 。这个子数组的重要性就是 k + 5 。
 * 找出并返回拆分 nums 的所有可行方案中的最小代价。
 */

//周赛t4 ，区间预处理 + 动态规划
public class 拆分数组的最小代价 {
    public int minCost(int[] nums, int k) {
        int n = nums.length;
        //dp[i]:表示从 i 到 n-1 的最小代价。
        var dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;
        //cnt[i][j] : [nums[i],nums[j]]子数组被裁剪后的长度
        var cnt = new int[n][n];
        for (int i = 0; i < n; i++) {
            var map = new HashMap<Integer, Integer>();
            int cntt = 0;
            for (int j = i; j < n; j++) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                if (map.get(nums[j]) == 1) {
                    //
                } else if (map.get(nums[j]) == 2) {
                    cntt += 2;
                } else {
                    cntt++;
                }
                cnt[i][j] = cntt;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            //nums[i]拆分，[nums[i],nums[j]]拆成新的，接上后面的dp[j+1]
            for (int j = i; j < n; j++) {
                int cost = k;
//                这里是超时的写法，需要预处理优化
//                Set<Integer> set = new HashSet<>();
//                for (int a = i; a <= j; a++) set.add(nums[a]);
//                var map = new HashMap<Integer, Integer>();
//                for (int a = i; a <= j; a++)
//                    map.put(nums[a], map.getOrDefault(nums[a], 0) + 1);
//                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//                    if (entry.getValue() > 1) cost += entry.getValue();
//                }
                cost += cnt[i][j];
                dp[i] = Math.min(dp[i], dp[j + 1] + cost);
            }
        }
        return dp[0];
    }
}

