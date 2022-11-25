package 双指针;

//数组被大于right的数字分成了多块，遍历数组的时候，考虑将下标i作为最后一位，如何得到有效子数组的个数？
public class 区间子数组个数 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int n = nums.length;
        int lEdge = -1; //左边的大于right值的下标
        int lValid = -1; //左边的介于[left : right] 的值 的下标
        //遍历到下标i时，将下标i作为子数组的最后一位，区间子数组的个数为 rValid - ledge
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > right) {
                lEdge = i;
                lValid = i;
            } else if (nums[i] < left) {
                res += lValid - lEdge;
            } else {
                lValid = i;
                res += lValid - lEdge;
            }
        }
        return res;
    }
}
