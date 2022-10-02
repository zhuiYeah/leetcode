package 位运算;

//与运算 &
//即：两位同时为“1”，结果才为“1”，否则为0

//两个数进行与运算，所得的值只会变小

////312场周赛
public class 按位与最大的最长子数组 {
//    public int longestSubarray(int[] nums) {
//        int maxValue = 0;
//        int maxLen = 0;
//        int and = 0;
//        int left = 0;
//        for (int right = 0; right < nums.length; right++) {
//
//        }
//    }
}

//属于是脑筋急转弯了
class edddedsew {
    public int longestSubarray(int[] nums) {
        int maxValue = 0;
        //找到最大值
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
            }
        }
        int res = 0;
        int start = -1;
        //找到最大值的连续最长区间
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == maxValue) {
                res = Math.max(i - start , res);
            } else {
                start = i;
            }
        }
        return res;
    }
}
