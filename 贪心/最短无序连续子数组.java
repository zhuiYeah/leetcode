package 贪心;

//部分排序
public class 最短无序连续子数组 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int left = -1, right = -2;
        var max = nums[0];
        var min = nums[n - 1];
        //从左到右的遍历记录最大值，如果当前值比最大值小，那么他就是右边界
        for (int i = 1; i < n; i++) {
            if (nums[i] >= max) max = nums[i];
            else right = i;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] <= min) min = nums[i];
            else left = i;
        }
        return right - left  +1;
    }
}
