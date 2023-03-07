package 动态规划;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 你现在使用骰子模拟器连续投掷n次骰子
 * 但是这个模拟器有一个特点，就是 连续投出i的数目不可能超过 rollMax[i]次 ， i从1开始，到6结束
 * <p>
 * 那么一共存在多少种序列的可能性
 * <p>
 * 例如 n = 2 , rollMax = [1,1,2,2,2,3]
 * 一共投两次，1，2只能连续出现一次，所以不存在序列（1，1），（2，2），所以结果为 36 - 2
 */


/**
 * dp[i][j] : 以j个i结尾的 序列总数
 *
 * 每一次投掷更新全部的dp[i][j]
 * */
public class _掷骰子模拟 {
    private final int MOD = (int) (1e9 + 7);

    public int dieSimulator(int n, int[] rollMax) {
        //dp[i][j] : 以j个i结尾的 序列总数
        var dp = new int[7][16];
        dp[1][1] = dp[2][1] = dp[3][1] = dp[4][1] = dp[5][1] = dp[6][1] = 1; //初始化第一次投掷
        var MaxFre = new ArrayList<Integer>(); //MaxFre.get(i): 数字i最多连续出现的次数
        MaxFre.add(0);
        for (int x : rollMax) MaxFre.add(x);
        int[] sum = new int[7]; //sum[i]：当前以i作为结尾的数字之和
        for (int o = 2; o <= n; o++) { //共进行n次投掷
            Arrays.fill(sum,0);
            for (int i = 1; i <= 6; i++) for (int fre = 1; fre <= 15; fre++) sum[i] = (dp[i][fre] + sum[i]) % MOD;
            for (int fre = 15; fre >= 2; fre--) {//以次数fre(2～15)次num结尾,那么必定继承前面的dp[num][fre-1]
                for (int num = 1; num <= 6; num++) {
                    if (fre > MaxFre.get(num)) continue;//数字num是不可能连续出现fre次的
                    dp[num][fre] = dp[num][fre - 1];
                }
            }
            //以次数fre=1 次num结尾，继承之前的不以num结束的所有dp之和
            for (int num = 1; num <= 6; num++) { //计算dp[num][1]
                int sumx = 0;
                for (int j = 1; j <= 6; j++) {
                    if (j == num) continue;
                    sumx = (sumx + sum[j]) % MOD;
                }
                dp[num][1] = sumx;
            }
        }
        long res = 0;
        for (int i = 1; i <= 6; i++) for (int j = 1; j <= 15; j++) res = (res + dp[i][j]) % MOD;
        return (int) res;
    }
}


class fregver {
    public static void main(String[] args) {
        new _掷骰子模拟().dieSimulator(3, new int[]{1, 1, 1, 2, 2, 3});
    }
}
