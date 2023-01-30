package 链蒸蒸简单;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//其实还有点小麻烦，甚至还用到了堆
public class 按照频率将数组升序排序 {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> fre = new HashMap<Integer, Integer>();
        for (int num : nums) {
            fre.put(num, fre.getOrDefault(num, 0) + 1);
        }
        var pq = new PriorityQueue<int[]>((a, b) -> {
            if (a[1] == b[1]) {
                //如果频率相同的话，按照数字大小降序排序
                return b[0] - a[0];
            } else {
                //按照频率升序排序
                return a[1] - b[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : fre.entrySet()) {
            int[] x = new int[]{entry.getKey(), entry.getValue()};
            pq.add(x);
        }
        int ptr = 0;
        while (!pq.isEmpty()) {
            var x = pq.poll();
            for (int i = 0; i < x[1]; i++) {
                nums[ptr] = x[0];
                ptr++;
            }
        }
        return nums;
    }
}
