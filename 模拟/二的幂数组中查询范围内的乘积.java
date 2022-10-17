package 模拟;

import java.util.ArrayList;

public class 二的幂数组中查询范围内的乘积 {
    public int[] productQueries(int n, int[][] queries) {
        final long MOD = (long) (1e9 + 7);
        String bin = Integer.toBinaryString(n);
        var power = new ArrayList<Integer>();
        int bit = 0;
        for (int i = bin.length() - 1; i >= 0; i--, bit++) {
            if (bin.charAt(i) == '1') {
                power.add((int) Math.pow(2, bit));
            }
        }
        int len = queries.length;
        int[] answer = new int[len];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0], right = queries[i][1];
            long sum = 1;
            for (int j = left; j <= right; j++) {
                sum = sum * (long)power.get(j) % MOD;
            }
            answer[i] = (int)sum;
        }
        return answer;
    }
}
