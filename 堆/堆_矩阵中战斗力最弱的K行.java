package 堆;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 堆_矩阵中战斗力最弱的K行 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[] rowSum = new int[m];
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    break;
                }
                sum++;
            }
            rowSum[i] = sum;
        }
        //大顶堆，堆顶是k个最弱 中的 最强的一个
        var pq = new PriorityQueue<Integer>((a, b) -> {
            if (rowSum[b] == rowSum[a]) {
                return b - a;
            } else {
                return rowSum[b] - rowSum[a];
            }
        });
        for (int i = 0; i < m; i++) {
            if (pq.size() != k) {
                pq.add(i);
            } else {
                if (rowSum[pq.peek()] > rowSum[i]) {
                    pq.poll();
                    pq.add(i);
                }
            }
        }
        var res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = pq.poll();
        }
        return res;
    }
}
