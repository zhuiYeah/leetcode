package _周赛;

//315场周赛 ， 子数组 ， 所以我认为是滑动窗口

public class 统计定界子数组的数目 {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0L;
        int minIndex = -1, maxIndex = -1, overIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > maxK || num < minK) overIndex = i;
            if (num == minK) minIndex = i;
            if (num == maxK) maxIndex = i;
            res += Math.max(0, Math.min(minIndex, maxIndex) - overIndex);
        }
        return res;
    }
}
