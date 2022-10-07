package 排序;

import java.security.KeyStore;
import java.util.HashMap;
import java.util.PriorityQueue;

public class 前k个高频元素 {
    public int[] topKFrequent(int[] nums, int k) {
        //映射一个数字和它出现的频率
        var fre = new HashMap<Integer, Integer>();
        var pq = new PriorityQueue<Integer>((a, b) -> {
            return fre.get(a) - fre.get(b);
        });
        for (int num : nums) {
            fre.put(num, fre.getOrDefault(num, 0) + 1);
        }
        for (HashMap.Entry<Integer, Integer> entry : fre.entrySet()) {
            if (pq.size() < k) {
                pq.add(entry.getKey());
            } else {
                if (entry.getValue() > fre.get(pq.peek())) {
                    pq.poll();
                    pq.add(entry.getKey());
                }
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}
