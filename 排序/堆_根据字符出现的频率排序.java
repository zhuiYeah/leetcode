package 排序;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 堆_根据字符出现的频率排序 {
    public String frequencySort(String s) {
        var map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        var pq = new PriorityQueue<Character>((a, b) -> {
            return map.get(b) - map.get(a);
        });
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(entry.getKey());
        }
        var sb = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.poll();
            sb.append(String.valueOf(c).repeat(map.get(c)));
        }
        return sb.toString();
    }
}
