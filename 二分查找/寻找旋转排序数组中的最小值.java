package 二分查找;

public class 寻找旋转排序数组中的最小值 {
    public int findMin(int[] nums) {
        int n = nums.length;
        int rightMax = nums[n - 1];
        //if (n == 1) return rightMax;
        //画蛇添足
//        //考虑完全降序的情况
//        //if (rightMax < nums[n - 2]) return rightMax;
//        //考虑完全升序的情况
//        if (nums[0] < rightMax) return nums[0];
        int res = rightMax;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < rightMax) {
                //mid落在右区间内，最小值还在左边，当前位置可能是最小值
                res = nums[mid];
                right = mid - 1;
            } else if (nums[mid] > rightMax) {
                //mid落在左区间内，最小值在右边，当前位置不可能是最小值（左区间的最小值都比右区间的大）
                left = mid + 1;
            } else {
                break;
            }
        }
        return res;
    }
}
