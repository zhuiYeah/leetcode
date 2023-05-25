package 堆;

import java.util.PriorityQueue;

public class 蓄水 {
    public int storeWater(int[] bucket, int[] vat) {
        int n = bucket.length;
        int base = 0;
        for (int i = 0; i < n; i++) {
            if (bucket[i] == 0) {
                if (vat[i] == 0) continue;
                base++;
                bucket[i]++;
            }
        }
        int min = Integer.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> {
            return vat[b] * bucket[a] - vat[a] * bucket[b];
        });
        for (int i = 0; i < n; i++) {
            if (bucket[i] == 0 && vat[i] == 0) continue;
            pq.add(i);
        }
        if (pq.isEmpty()) return 0;
        while (base < min) {
            assert !pq.isEmpty();
            int idx = pq.poll();
            min = Math.min(min, base + (int) Math.ceil(vat[idx] * 1.0 / bucket[idx]));
            base++;
            bucket[idx]++;
            pq.add(idx);
        }
        return min;
    }
}
