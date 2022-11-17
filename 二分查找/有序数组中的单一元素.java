package 二分查找;

//给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。

//剑指offer
public class 有序数组中的单一元素 {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int left = 1, right = n - 2;
        //边界check
        if (nums[0] != nums[1]) return nums[0];
        if (nums[n - 1] != nums[n - 2]) return nums[n - 1];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int other = mid;
            if (mid % 2 == 0) other++;
            else other--;
            if (nums[mid] == nums[other]) {
                left = mid + 1;
            } else {
                if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) return nums[mid];
                right = mid - 1;
            }
        }
        return -1;
    }
}
