package 二分查找;

public class 在排序数组中查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int targetIndex = -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                targetIndex = mid;
                break;
            }
        }
        if (targetIndex == -1) {
            return new int[]{-1, -1};
        }
        int start = targetIndex, end = targetIndex;
        for (int i = targetIndex; i >= 0; i--) {
            if (nums[i] != target) break;
            start = i;
        }
        for (int i = end; i < nums.length; i++) {
            if (nums[i] != target) break;
            end = i;
        }
        return new int[]{start, end};
    }
}
