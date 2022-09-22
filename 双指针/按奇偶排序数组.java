package 双指针;

//使一个给定数组 的 奇数在后偶数在前
public class 按奇偶排序数组 {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 == 0) left++;
            while (left < right && nums[right] % 2 == 1) right--;
            int tmp = nums[right];
            nums[right] = nums[left];
            nums[left] = tmp;
        }
        return nums;
    }
}


