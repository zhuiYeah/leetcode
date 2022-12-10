package 动态规划;

import java.util.Arrays;


//wa 了两次得出了正确解
// 第一次是将 dp[i] 拓展为 dp[i][0] dp[i][1]
// 第二次是将 找到之前的第一个能承载i的长方体 这个逻辑 变成 找到之前全部的能承载i的长方体
public class 堆叠长方体的最大高度 {
    public int maxHeight(int[][] cuboids) {
        int n = cuboids.length;
        var dp = new int[n][2];
        // dp[i][0] : 不选择长方体i，能摆放的最大高度
        // dp[i][1] : 选择长方体i，能摆放的最大高度
        for (int i = 0; i < cuboids.length; i++)
            Arrays.sort(cuboids[i]);


        Arrays.sort(cuboids, (a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            } else {
                if (a[1] != b[1]) {
                    return b[1] - a[1];
                } else {
                    if (a[2] != b[2]) {
                        return b[2] - a[2];
                    } else {
                        return 0;
                    }
                }
            }
        });
        //System.out.println(Arrays.deepToString(cuboids));
        dp[0][0] = 0;
        dp[0][1] = cuboids[0][2];
        for (int i = 1; i < n; i++) {
            //不使用当前长方体的话，直接继承便可以
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            //即使不能找到任何一个承载自己的长方体，以自己为底的话也能得到一个最小的dp[i][1]
            dp[i][1] = cuboids[i][2];
            // 枚举之前的全部长方体，看看能不能完全容纳自己
            for (int j = i - 1; j >= 0; j--) {
                if (!isAllSmaller(cuboids, i, j)) continue;
                dp[i][1] = Math.max(dp[i][1], cuboids[i][2] + dp[j][1]);
            }
        }

        //System.out.println(Arrays.deepToString(dp));
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    private boolean isAllSmaller(int[][] x, int a, int b) {
        return x[a][0] <= x[b][0] && x[a][1] <= x[b][1] && x[a][2] <= x[b][2];
    }
}

class dewdew {
    public static void main(String[] args) {
        new 堆叠长方体的最大高度().maxHeight(new int[][]{{74, 7, 80}, {7, 52, 61}, {62, 41, 37}, {91, 58, 26}, {88, 98, 5}, {72, 93, 23}, {56, 58, 94}, {88, 8, 64}, {32, 55, 5}});
    }
}
