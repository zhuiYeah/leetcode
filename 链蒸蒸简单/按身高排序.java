package 链蒸蒸简单;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 按身高排序 {
    public String[] sortPeople(String[] names, int[] heights) {
        var pq = new PriorityQueue<Integer>((a, b) -> {
            return heights[b] - heights[a];
        });
        for (int i = 0; i < names.length; i++) {
            pq.add(i);
        }
        var res = new String[names.length];
        int ptr = 0;
        while (!pq.isEmpty()) {
            int index = pq.poll();
            res[ptr] = names[index];
            ptr++;
        }
        return res;
    }
}

class dedre {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        String[] res = new String[n];
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> heights[b] - heights[a]);
        for (int i = 0; i < n; i++) res[i] = names[idx[i]];
        return res;
    }
}
