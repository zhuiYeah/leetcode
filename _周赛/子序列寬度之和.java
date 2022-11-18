package _周赛;

import java.util.Arrays;

//用mod預處理2的冪次 + 貢獻法
public class 子序列寬度之和 {
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        final int MOD = (int) (1e9 + 7);
        int[] pow2 = new int[nums.length];
        pow2[0] = 1;
        for (int i = 1; i < pow2.length; i++)
            pow2[i] = 2 * pow2[i - 1] % MOD;
    
        long res = 0;
        //2^max記錄當前元素作爲最大值出現的次數
        int min = nums.length - 1, max = 0;
        for (int i = 0; i < nums.length; i++) {
            res += (long) (pow2[max] - pow2[min]) * nums[i];
            // if (res >= mod) res%=mod;
            min--;
            max++;
        }
        return (int) (res % MOD + MOD) % MOD;
    }

}


