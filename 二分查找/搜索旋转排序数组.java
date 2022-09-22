package 二分查找;

//二分查找部分有序的数组
public class 搜索旋转排序数组 {
    public static int search(int[] nums, int target) {
        //通过rightMax来判断处于左半区间还是右半区间
        int rightMax = nums[nums.length - 1];
        if (target == rightMax) return nums.length - 1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == rightMax) return -1;
            if (nums[mid] > target) {
                if (nums[mid] > rightMax) {
                    if (target > rightMax) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] < target) {
                if (nums[mid] > rightMax) {
                    left = mid + 1;
                } else {
                    if (target > rightMax) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        var num = new int[]{3, 5, 1};
        search(num, 3);
    }
}
