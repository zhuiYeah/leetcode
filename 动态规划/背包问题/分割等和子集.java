package 动态规划.背包问题;

import java.util.Arrays;


/**0 1 背包 还是写成二维的dp数组更好理解 一个维度表示背包容量 一个维度表示 物品
 * 一般先遍历物品再遍历背包更好理解
 * */
//先物品后背包，背包从大到小
public class 分割等和子集 {
    public boolean canPartition(int[] nums) {
        int cap = Arrays.stream(nums).sum();
        if (cap % 2 != 0) return false;
        cap /= 2;
        //dp[i] : 容量为i的背包能装载放入最大价值
        var dp = new int[cap + 1];
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {//当前物品为i
            for (int j = cap; j > 0; j--) { //当前背包容量为j
                if (nums[i] <= j) {
                    dp[j] = Math.max(dp[j - nums[i]] + nums[i], dp[j]);
                }
            }
        }
        return dp[cap] == cap;
    }
}
