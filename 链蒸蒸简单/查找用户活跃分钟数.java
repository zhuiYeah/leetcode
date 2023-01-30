package 链蒸蒸简单;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//hashmap + hashset
public class 查找用户活跃分钟数 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        var res = new int[k];
        var map = new HashMap<Integer, Set<Integer>>();
        for (int[] log : logs) {
            var allTime = map.getOrDefault(log[0], new HashSet<Integer>());
            allTime.add(log[1]);
            map.put(log[0], allTime);
        }
        var map1 = new HashMap<Integer, Integer>();
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet())
            map1.put(entry.getKey(), entry.getValue().size());
        for (Map.Entry<Integer, Integer> entry : map1.entrySet())
            res[entry.getValue() - 1]++;

        return res;
    }
}
