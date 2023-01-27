package 动态规划;

/**
 * 删掉数组的一个元素，使得得到的新数组的 奇数下标之和 == 偶数下标之和
 * 问一共有多少种方案
 * */

//也算是动态规划吧
public class 生成平衡数组的方案数 {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length, cnt = 0;
        //dpLeft[i][0] : i下标左边的下标为偶数的数字之和
        var dpLeft = new int[n][2];
        int sum_of_even = 0, sum_of_odd = 0;
        for (int i = 0; i < n; i++) {
            dpLeft[i][0] = sum_of_even;
            dpLeft[i][1] = sum_of_odd;
            if (i % 2 == 0) sum_of_even += nums[i];
            else sum_of_odd += nums[i];
        }
        var dpRight = new int[n][2];
        sum_of_even = sum_of_odd = 0;
        for (int i = n - 1; i >= 0; i--) {
            dpRight[i][0] = sum_of_even;
            dpRight[i][1] = sum_of_odd;
            if (i % 2 == 0) sum_of_even += nums[i];
            else sum_of_odd += nums[i];
        }
        for (int i = 0; i < n; i++)
            if (dpLeft[i][0] + dpRight[i][1] == dpLeft[i][1] + dpRight[i][0]) cnt++;
        return cnt;
    }
}
