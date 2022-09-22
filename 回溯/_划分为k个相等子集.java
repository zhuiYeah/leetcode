package 回溯;


import java.util.Arrays;

//9.2
//整体就是一个暴力的解法，先算出子集的和是多少，并抽象成k个桶，每个桶的值是子集的和。
// 然后尝试所有不同的组合（即放数到桶中），如果存在一种组合可以使每个桶都正好放下，那么返回可以。如果不存在，返回不可以。
public class _划分为k个相等子集 {
    int[] bucket; //回溯必须要处理的
    int[] nums; //不会变

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        sum /= k;
        int[] bucket = new int[k];
        Arrays.fill(bucket, sum);
        this.bucket = bucket;
        Arrays.sort(nums);
        this.nums = nums;
        if (nums[nums.length - 1] > sum) return false;
        return backtracking(nums.length - 1); //从最大的开始装
    }

    public boolean backtracking(int curIndex) {
        if (curIndex < 0) return true; //全部都装完了
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] == nums[curIndex] || bucket[i] > nums[curIndex] && bucket[i] - nums[curIndex] >= nums[0]) {//这里的判断条件暗藏了一个减枝的思路
                bucket[i] -= nums[curIndex];
                if (backtracking(curIndex - 1)) {
                    return true;
                }
                //走到这里说明bucket[i]装nums[curIndex]是错误的，找下一个桶装nums[curIndex]吧
                bucket[i] += nums[curIndex];
            }
        }
        //如果所有桶装nums[curIndex]都是错的
        return false;
    }
}


//////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
//9.20
class dwqdwqdqw {
    int[] nums;
    int[] buckets;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;
        sum /= k;
        //一共有k个桶，我能否填满这些桶
        int[] buckets = new int[k];
        Arrays.fill(buckets, sum);
        Arrays.sort(nums);
        int n = nums.length;
        this.nums = nums;
        this.buckets = buckets;
        //从最重的物品开始装
        return backtracking(n - 1);
    }

    public boolean backtracking(int index) {
        if (index == -1) return true;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] == nums[index] || buckets[i] - nums[index] >= nums[0]) {
                buckets[i] -= nums[index];
                if (backtracking(index - 1)) {
                    return true;
                }
                buckets[i] += nums[index];
            }
        }
        return false;
    }
}