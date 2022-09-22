package 贪心;

import java.util.Arrays;

//O(n * log n)
public class _无重叠区间 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);//按照区间的右边界从小到大来排序
        int res = 1;//将记录最大无重叠区间的个数
        int end = intervals[0][1]; //记录区间的边界
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) { //找到了新的无重叠区间
                res++;
                end = intervals[i][1]; //更新边界
            }
        }
        return intervals.length - res;
    }
}
