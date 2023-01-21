package 数学;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个数组 nums ，数组中只包含非负整数。定义 rev(x) 的值为将整数 x 各个数字位反转得到的结果。比方说 rev(123) = 321 ， rev(120) = 21 。我们称满足下面条件的下标对 (i, j) 是 好的 ：
 * 0 <= i < j < nums.length
 * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
 * 请你返回好下标对的数目。由于结果可能会很大，请将结果对 10^9 + 7 取余 后返回
 */

/**
 * nums[i] - rev(nums[i]) == nums[j] - rev(nums[j]) ,也就是说，每个数字都有自己的特征值，特征值相同的数字可以组成一个好对子
 */
public class 统计一个数组中好对子的数目 {
    final int MOD = (int) (1e9 + 7);

    public int countNicePairs(int[] nums) {
        //特征值 -》 该特征值出现的次数
        var map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            int value = num - reverseNum(num);
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        long res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue() - 1;
            res = (res + (long) (value + 1) * value / 2) % MOD;
        }
        return (int) res;
    }

    private int reverseNum(int x) {
        if (x < 10) return x;
        var sb = new StringBuilder();
        while (x > 0) {
            sb.append(x % 10);
            x /= 10;
        }
        return Integer.parseInt(sb.toString());
    }
}
