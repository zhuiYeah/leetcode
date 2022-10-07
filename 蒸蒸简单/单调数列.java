package 蒸蒸简单;

//判断一个数列是否单调
public class 单调数列 {
    public boolean isMonotonic(int[] nums) {
        if (nums.length == 1) return true;
        int diff = nums[1] - nums[0];
        for (int i = 2; i < nums.length; i++) {
            int cha = nums[i] - nums[i - 1];
            if (diff == 0 && cha != 0) diff = cha;
            if (diff * cha < 0) return false;
        }
        return true;
    }
}