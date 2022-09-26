package 太简单了没意思;

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
