package 蒸蒸简单;

import java.util.PriorityQueue;

public class 化学反应 {
    public int lastMaterial(int[] material) {
        var pq = new PriorityQueue<Integer>((a, b) -> {
            return b - a;
        });
        for (int j : material) {
            pq.add(j);
        }
        while (!pq.isEmpty()) {
            if (pq.size() == 1) break;
            int a = pq.poll();
            int b = pq.poll();
            int abs = Math.abs(a - b);
            if (abs == 0) continue;
            pq.add(abs);
        }
        if (pq.isEmpty()) return 0;
        return pq.poll();
    }
}
