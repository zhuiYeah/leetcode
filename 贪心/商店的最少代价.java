package 贪心;

//贪心 + 预处理
public class 商店的最少代价 {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] lN = new int[n + 1];
        int[] rY = new int[n + 1];
        lN[0] = 0;
        for (int i = 0; i < n; i++) {
            if (customers.charAt(i) == 'N') lN[i + 1] = lN[i] + 1;
            else lN[i + 1] = lN[i];
        }
        rY[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (customers.charAt(i) == 'Y') rY[i] = rY[i + 1] + 1;
            else rY[i] = rY[i + 1];
        }
        int min = Integer.MAX_VALUE;
        int res = -1;
        for (int i = n; i >= 0; i--) {
            if (lN[i] + rY[i] <= min) {
                min = lN[i] + rY[i];
                res = i;
            }
        }

        return res;
    }
}
