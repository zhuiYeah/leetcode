package 动态规划;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class 删除并获得点数 {
    public static int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> fre = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            fre.put(nums[i], fre.getOrDefault(nums[i], 0) + 1);
        }
        int[] nums1 = new int[fre.size()];
        int[] fre1 = new int[fre.size()];
        int i = 0;
        for (HashMap.Entry<Integer, Integer> e : fre.entrySet()) {
            nums1[i] = e.getKey();
            i++;
        }
        Arrays.sort(nums1);
        for (i = 0; i < nums1.length; i++) {
            fre1[i] = fre.get(nums1[i]);
        }
        int[] dp = new int[nums1.length];
        dp[0] = nums1[0] * fre1[0];
        if (nums1.length == 1) {
            return dp[0];
        }
        if (nums1[1] == nums1[0] + 1) {
            dp[1] = Math.max(nums1[0] * fre1[0], nums1[1] * fre1[1]);
        } else {
            dp[1] = nums1[0] * fre1[0] + nums1[1] * fre1[1];
        }

        for (i = 2; i < nums1.length; i++) {
            if (nums1[i] != nums1[i - 1] + 1) {
                dp[i] = dp[i - 1] + nums1[i] * fre1[i];
            } else {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums1[i] * fre1[i]);
            }
        }
        return dp[i - 1];
    }

    public static void main(String[] args) {
        deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4});
    }

}
