package 动态规划;

import java.util.ArrayList;

//给定所有兼职工作的开始时间，结束时间 ，利润 ； 给出你能获得的最大收益
public class 规划兼职工作 {
    int[] startTime;
    int[] endTime;
    int[] profit;
    int[] dp;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        this.startTime = startTime;
        this.endTime = endTime;
        this.profit = profit;
        var dp = new int[n];
        this.dp = dp;
        //dp[i] : 当前是第i个兼职工作，当前能获得的最大收入为 dp[i]
        //dp[i] = Math.max(dp[i-1],profit[i]+dp[最后一份可以选择的工作])
        mergeSort(0, n - 1);
        dp[0] = profit[0];
        for (int i = 1; i < n; i++) {
            //如果要选择当前任务i，当前任务的开始时间为start[i] ;   前一个可执行任务的结束时间必须小于等于start[i]
            int preMax = binSearch(startTime[i], i);
            dp[i] = Math.max(dp[i - 1], preMax + profit[i]);
        }
        return dp[n - 1];
    }

    public int binSearch(int maxEndtime, int index) {
        int max = 0;
        int left = 0, right = index;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (endTime[mid] <= maxEndtime) {
                max = dp[mid];
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return max;
    }

    public void mergeSort(int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);
        int i = start, j = mid + 1;
        var endend = new ArrayList<Integer>();
        var startstart = new ArrayList<Integer>();
        var profitprofit = new ArrayList<Integer>();
        while (i <= mid && j <= end) {
            if (endTime[i] < endTime[j]) {
                endend.add(endTime[i]);
                startstart.add(startTime[i]);
                profitprofit.add(profit[i]);
                i++;
            } else {
                endend.add(endTime[j]);
                startstart.add(startTime[j]);
                profitprofit.add(profit[j]);
                j++;
            }
        }
        while (i <= mid) {
            endend.add(endTime[i]);
            startstart.add(startTime[i]);
            profitprofit.add(profit[i]);
            i++;
        }
        while (j <= end) {
            endend.add(endTime[j]);
            startstart.add(startTime[j]);
            profitprofit.add(profit[j]);
            j++;
        }
        for (i = start; i <= end; i++) {
            endTime[i] = endend.get(i - start);
            startTime[i] = startstart.get(i - start);
            profit[i] = profitprofit.get(i - start);
        }
    }

    public static void main(String[] args) {
        long x = 1L << (9 + 9 + 9 + 12 - 1);
        System.out.println(x/1024/1024/1024 +"GB");
    }
}
