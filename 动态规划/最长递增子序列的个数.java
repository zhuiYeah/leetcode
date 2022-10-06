package 动态规划;


//一个随意的数组，首先先得到他的最长递增子序列的长度，接下来 所有的最长子序列 一共有多少个呢？

//据说本题可以使用树状数组和线段树

//多测试几个例子就能通过了
public class 最长递增子序列的个数 {
    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        var dp = new int[n][2];
        //dp[i][0] 以第i个数作为递增子序列的结尾 ， 递增子序列的最长长度
        //取得dp[i][0] 这样最长子序列的序列数有 dp[i][1]个
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
        }
        int max = 1;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    int x = dp[j][0] + 1;
                    if (x > dp[i][0]) {
                        dp[i][0] = x;
                        dp[i][1] = dp[j][1];
                    } else if (x == dp[i][0]) {
                        dp[i][1]+= dp[j][1];
                    }
                }
            }
            max = Math.max(max, dp[i][0]);
        }
//        for (int i = 0; i < dp.length; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        int res = 0;
        for (int i = 0; i <dp.length; i++) {
            if (dp[i][0] == max) {
                res += dp[i][1];
            }
        }
        return res;
    }

    public static void main(String[] args){
        var nums = new int[]{1,1,1,2,2,2,3,3,3};
        findNumberOfLIS(nums);
    }
}
