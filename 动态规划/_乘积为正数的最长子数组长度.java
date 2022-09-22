package 动态规划;

//类滑动窗口
public class _乘积为正数的最长子数组长度 {
    //包含负数个数为偶数个的最长子序列长度
    public int getMaxLen(int[] nums) {
        int zeroPositions = -1;
        int start = 0; //第一个负数的位置
        //  int end = 0; //最后一个负数的位置 ， 好像不需要
        int numOfNega = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroPositions = i;
                start = i + 1;
                //end = i + 1;
                numOfNega = 0;
            } else if (nums[i] < 0) {
                if (numOfNega == 0) {
                    start = i;
                }
                // end = i;
                numOfNega++;
                if (numOfNega % 2 == 0) {
                    res = Math.max(res, i - zeroPositions);
                } else {
                    res = Math.max(res, i - start);
                }
            } else {
                if (numOfNega % 2 == 0) {
                    res = Math.max(res, i - zeroPositions);
                } else {
                    res = Math.max(res, i - start);
                }
            }
        }
        return res;
    }
}
