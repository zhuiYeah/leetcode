package 堆;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 最大平均通过率 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        var pq = new PriorityQueue<int[]>((a, b) -> {
            //这个值如果小于0，则前面的值优先；如果大于0，则后面的值优先
            /**
             * val 等价于 {(x1+1)/(y1+1) - x1/y1} - {(x2 + 1)/(y2 + 1) - x2 / y2}
             * */
            long val = (long) b[1] * (b[1] + 1) * (a[1] - a[0]) - (long) a[1] * (a[1] + 1) * (b[1] - b[0]);
            if (val == 0) return 0;
            else if (val < 0) return 1;
            else return -1;
        });
        pq.addAll(Arrays.asList(classes));
        for (int i = 0; i < extraStudents; i++) {
            int[] cur = pq.poll();
            assert cur != null;
            cur[0]++;
            cur[1]++;
            pq.add(cur);
        }
        double res = 0.0;
        while (!pq.isEmpty()) {
            var cur = pq.poll();
            res += (double) cur[0] / (double) cur[1];
        }
        return res / classes.length;
    }
}
