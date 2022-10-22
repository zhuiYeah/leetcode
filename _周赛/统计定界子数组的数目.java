package _周赛;

//315场周赛 ， 子数组 ， 所以我认为是滑动窗口
//如果一段连续的数组，其中包含minK和maxK，那么称之为定界子数组 ， 找到一个数组的所有定界子数组的个数


//如果nums中的数字都在 minK 和 maxK之内 ，那么在一次遍历的过程中不断更新minK的下标 minIndex以及maxK的下标maxIndex 。
// 对于nums[i]，如果minK与maxK已经在前面（包含自身）出现，那么，以i位置作为结尾的满足条件的定界子数组的个数为min(maxIndex,minIndex)+1min(maxIndex,minIndex)+1min(maxIndex,minIndex)+1;
//
//现在考虑吧更普遍的情况，那么在一次遍历的过程中不断更新minK的下标 minIndex以及maxK的下标maxIndex，以及越界元素的下标overIndex。对于nums[i]，以i为结尾的定界子数组的个数为 Math.max(0,Math.min(maxIndex,minIndex)−overIndex)Math.max(0,Math.min(maxIndex,minIndex)-overIndex)Math.max(0,Math.min(maxIndex,minIndex)−overIndex)

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
