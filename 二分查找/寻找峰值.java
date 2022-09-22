package 二分查找;

//寻找数组中任意一个峰值的下标
public class 寻找峰值 {
    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;
        int left = 1, right = n - 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return mid;
            }
            //右边一定存在峰值
            if (nums[mid + 1] > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        var nums = new int[]{3, 4, 3, 2, 1};
        findPeakElement(nums);
    }
}
