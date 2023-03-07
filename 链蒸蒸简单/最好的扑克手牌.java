package 链蒸蒸简单;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class 最好的扑克手牌 {
    public String bestHand(int[] ranks, char[] suits) {
        var map1 = new HashMap<Integer, Integer>();
        var map2 = new HashSet<Character>();
        for (int i : ranks) map1.put(i, map1.getOrDefault(i, 0) + 1);
        for (char c : suits) map2.add(c);
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) max = Math.max(max, entry.getValue());
        if (map2.size() == 1) return "Flush";
        if (max >= 3) return "Three of a Kind";
        if (max == 2) return "Pair";
        if (map1.size() == 5) return "High Card";
        return null;
    }
}
