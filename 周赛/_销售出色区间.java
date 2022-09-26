package 周赛;


import java.util.Deque;
import java.util.LinkedList;

//动态规划
//这动态规划挺暴力的 ， 超出内存限制
public class _销售出色区间 {
    public static int longestESR(int[] sales) {
        int n = sales.length;
        int[][] dp = new int[n][n];
        //dp[i][j]  ：在i j区间之内 销售出色的天数为
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (sales[i] > 8) {
                dp[i][i] = 1;
                max = 1;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            int count = sales[i] > 8 ? 1 : 0;
            for (int j = i + 1; j < n; j++) {
                int cc = count;
                if (sales[j] > 8) cc++;
                dp[i][j] += cc + dp[i + 1][j - 1];
                if (dp[i][j] > (j - i + 1) / 2) max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        longestESR(new int[]{1, 2, 3, 4});
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////
//暴力通过
class edndknewbjkcbjewkwefd {
    public int longestESR(int[] sales) {
        int n = sales.length;
        int count = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            count = 0;
            for (int j = i; j < n; j++) {
                if (sales[j] > 8) {
                    count++;
                }
                if (count > (j - i + 1) / 2) max = Math.max(max, (j - i + 1));
            }
        }
        return max;
    }
}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class dwedqwc{
    public int longestWPI(int[] hours) {
        int len = hours.length;
        int[] hours2 = new int[len];
        for (int i = 0; i < len; i++) {
            if (hours[i] > 8) {
                hours2[i] = 1;
            } else {
                hours2[i] = -1;
            }
        }
        int[] prefixSum = new int[len + 1];
        for (int i = 1; i < len + 1; i++) {
            prefixSum[i] = prefixSum[i - 1] + hours2[i - 1];
        }
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len + 1; i++) {
            if (stack.isEmpty() || prefixSum[stack.peek()] > prefixSum[i]) {
                stack.push(i);
            }
        }
        int ans = 0;
        for (int j = len; j >= ans; j--) {
            while (!stack.isEmpty()) {
                int i = stack.peek();
                if (prefixSum[j] > prefixSum[i]) {
                    ans = Math.max(ans, j - i);
                    stack.pop();
                } else {
                    break;
                }
            }

        }
        return ans;
    }
}
