package 排序;

import java.util.TreeSet;

//能否找到下标之差小于等于k，abs值之差小于等于

//HashSet是无序集合，TreeSet是有序集合，
public class _有序集合TreeSet_存在重复元素III {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<>();//有序集合
        for (int i = 0; i < n; i++) {
            Long x = set.ceiling((long) nums[i] - (long) t); //ceiling方法会给出set中最小的大于等于 nums[i] - t 的元素
            if (x != null && x <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}


//剑指offer
class defe {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            //ceiling方法会给出set中最小的大于等于 nums[i] - t 的元素
            Long maybe = set.ceiling((long) nums[i] - t);
            if (maybe != null && maybe <= (long) nums[i] + t) return true;
            set.add((long) nums[i]);
            //一次遍历的过程中保持set中只有k+1个元素
            if (i >= k) set.remove((long) nums[i - k]);
        }
        return false;
    }
}