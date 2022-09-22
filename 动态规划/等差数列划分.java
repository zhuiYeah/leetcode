package 动态规划;

public class 等差数列划分 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        int res = 0;
        int curDiff = nums[1] - nums[0]; //时刻记录当前等差数列的差
        int curSeqNum = 2;  //时刻记录当前等差数列达到的长度
        for (int i = 2; i < n; i++) {
            if (nums[i] - nums[i - 1] == curDiff) {
                curSeqNum++;
                res += curSeqNum - 2;
            } else {
                curDiff = nums[i] - nums[i - 1];
                curSeqNum = 2;
            }
        }
        return res;
    }
}
