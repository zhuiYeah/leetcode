package 链蒸蒸简单;

import java.util.HashMap;
import java.util.Map;

public class 柠檬水找零 {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int bill : bills) {
            if (bill == 5) {
                map.put(5, map.getOrDefault(5, 0) + 1);
            } else if (bill == 10) {
                if (map.getOrDefault(5, 0) == 0) return false;
                map.put(5, map.get(5) - 1);
                map.put(10, map.getOrDefault(10, 0) + 1);
            } else {
                int need = 15;
                if (map.getOrDefault(10, 0) != 0) {
                    need -= 10;
                    map.put(10, map.get(10) - 1);
                }
                while (need != 0 && map.getOrDefault(5, 0) != 0) {
                    need -= 5;
                    map.put(5, map.get(5) - 1);
                }
                if (need != 0) return false;
            }
        }
        return true;
    }
}
