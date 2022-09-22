package 排序;

import java.util.Arrays;

public class 合并区间 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        int ptr = 0;
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > end) {
                intervals[ptr][0] = start;
                intervals[ptr][1] = end;
                ptr++;
                start = intervals[i][0];
                end = intervals[i][1];
            } else if (intervals[i][1] > end) {
                end = intervals[i][1];
            }
        }
        intervals[ptr][0] = start;
        intervals[ptr][1] = end;
        ptr++;
        var res = new int[ptr][2];
        System.arraycopy(intervals, 0, res, 0, ptr);
        return res;

    }
}
