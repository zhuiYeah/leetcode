package 模拟;

public class 经营摩天轮的最大利润 {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int n = customers.length;
        int maxProfit = 0;//最大利润
        int res = -1;
        int profit = 0;//当前利润
        int wait = 0;//排队人数
        int cnt = 0;//记录轮转次数
        for (int i = 0; i < n; i++) {
            cnt++;
            wait += customers[i];
            int x = wait >= 4 ? 4 : wait;//本次上船人数
            wait -= x;
            profit += x * boardingCost - runningCost;
            if (profit > maxProfit) {
                maxProfit = profit;
                res = cnt;
            }
        }
        while (wait > 0) {
            cnt++;
            int x = wait >= 4 ? 4 : wait;
            wait -= x;
            profit += x * boardingCost - runningCost;
            if (profit > maxProfit) {
                maxProfit = profit;
                res = cnt;
            }
        }
        return res;
    }
}
