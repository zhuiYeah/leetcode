package 周赛;

import java.util.*;

public class 交通枢纽 {
    public int transportationHub(int[][] path) {
        int n = path.length;
        //记录 出发城市 以及 该城市能到达的所有城市
        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        //记录所有的仅有入口没有出口的目的城市
        Set<Integer> city = new HashSet<Integer>();
        for (int[] ints : path) {
            city.remove(ints[0]);
            var list = map.getOrDefault(ints[0], new ArrayList<Integer>());
            list.add(ints[1]);
            map.put(ints[0], list);
            if (!map.containsKey(ints[1])) city.add(ints[1]);
        }
        if (city.size() != 1) return -1;
        var x = map.get(path[0][0]);
        //结果已经包含在hashset之中
        Set<Integer> set = new HashSet<Integer>(x);
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            //xx记录共同可到达的目的地
            var xx = new ArrayList<Integer>();
            var y = entry.getValue();
            for (Integer integer : y) {
                if (set.contains(integer)) {
                    xx.add(integer);
                }
            }
            if (xx.size() == 0) return -1;
            set.clear();
            set.addAll(xx);
        }
        for (int des : set) {
            if (city.contains(des)) return des;
        }
        return -1;
    }
}
