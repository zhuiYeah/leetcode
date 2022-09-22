package 排序;

import java.util.PriorityQueue;

public class 有序矩阵中第k小的元素 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, (a, b) -> { //大顶堆，堆顶是第k个最小元素
            return b - a;
        });
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (pq.size() != k) {
                    pq.offer(matrix[i][j]);
                } else {
                    if (matrix[i][j] < pq.peek()) {
                        pq.poll();
                        pq.offer(matrix[i][j]);
                    }
                }
            }
        }
        return pq.peek();
    }
}
