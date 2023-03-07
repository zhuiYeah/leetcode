package 动态规划;


public class 使字符串平衡的最少删除次数 {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[][] dp = new int[n][2];
        //dp[i][0] ，表示线性dp到i位置以a为结尾的最小修改次数
        //dp[i][1],表示线性dp到i位置以b为结尾的最小修改次数
        dp[0][0] = s.charAt(0) == 'a' ? 0 : 1;
        dp[0][1] = s.charAt(0) == 'a' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'b') {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]);
            } else {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + 1;
            }

        }
        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }
}
