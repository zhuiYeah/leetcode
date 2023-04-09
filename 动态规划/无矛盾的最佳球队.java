package 动态规划;

import java.util.Arrays;


/**
 * 假设你是球队的经理。对于即将到来的锦标赛，你想组合一支总体得分最高的球队。球队的得分是球队中所有球员的分数 总和 。
 * <p>
 * 然而，球队中的矛盾会限制球员的发挥，所以必须选出一支 没有矛盾 的球队。如果一名年龄较小球员的分数 严格大于 一名年龄较大的球员，则存在矛盾。同龄球员之间不会发生矛盾。
 * <p>
 * 给你两个列表 scores 和 ages，其中每组 scores[i] 和 ages[i] 表示第 i 名球员的分数和年龄。请你返回 所有可能的无矛盾球队中得分最高那支的分数 。
 */

//排序 + dp(找到一个递增子序列，并且这个子序列的和最大)
public class 无矛盾的最佳球队 {
    public int bestTeamScore(int[] scores, int[] ages) {
        //按照年龄从小到大对score排序
        int n = scores.length;
        int[][] a = new int[n][2]; //a[i][0] 表示年龄, a[i][1]表示得分 ，按照年龄从小到大排序
        for (int i = 0; i < n; i++) {
            a[i][0] = ages[i];
            a[i][1] = scores[i];
        }
        Arrays.sort(a, (x, y) -> {
            if (x[0] == y[0]) {
                return x[1] - y[1];
            } else {
                return x[0] - y[0];
            }
        });
        int[] dp = new int[n];//取i个比分，能得到的最大分数
        dp[0] = a[0][1];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = a[i][1];
            for (int j = 0; j < i; j++) {
                if (a[j][1] > a[i][1]) continue;
                dp[i] = Math.max(dp[i], dp[j] + a[i][1]);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
