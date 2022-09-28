package 排序;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class 堆_第k个数 {
    public int getKthMagicNumber(int k) {
        var pq = new PriorityQueue<Long>();
        pq.add(1L);
        int[] prim = new int[]{3, 5, 7};
        Set<Long> set = new HashSet<>();
        set.add(1L);
        int cur = 0;
        while (true) {
            cur++;
            long min = pq.poll();
            if (cur == k) return (int) min;
            for (int i = 0; i < 3; i++) {
                long next = min * (long)prim[i];
                if (!set.contains(next)) {
                    set.add(next);
                    pq.add(next);
                }
            }
        }
    }

//    public int getKthMagicNumber(int k) {
//        int[] factors = {3, 5, 7};
//        Set<Long> seen = new HashSet<Long>();
//        PriorityQueue<Long> heap = new PriorityQueue<Long>();
//        seen.add(1L);
//        heap.offer(1L);
//        int magic = 0;
//        for (int i = 0; i < k; i++) {
//            long curr = heap.poll();
//            magic = (int) curr;
//            for (int factor : factors) {
//                long next = curr * factor;
//                if (seen.add(next)) {
//                    heap.offer(next);
//                }
//            }
//        }
//        return magic;
//    }


}
