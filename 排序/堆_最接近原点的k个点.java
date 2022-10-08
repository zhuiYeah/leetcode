package 排序;

import java.util.PriorityQueue;

public class 堆_最接近原点的k个点 {
    public int[][] kClosest(int[][] points, int k) {
        var pq = new PriorityQueue<int[]>((a, b) -> {
            return b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1];
        });
        for (int[] point : points) {
            if (pq.size() < k) {
                pq.add(point);
            } else {
                var x = pq.peek();
                assert x != null;
                if (point[0] * point[0] + point[1] * point[1] < x[0] * x[0] + x[1] * x[1]) {
                    pq.poll();
                    pq.add(point);
                }
            }
        }
        var res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
