package 排序;

import java.util.TreeSet;

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
