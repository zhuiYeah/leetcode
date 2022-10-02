package 哈希表;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

//考察哈希表和有序集合
//2022 9.16中国银联
public class 勘探补给 {
    public int[] explorationSupply(int[] station, int[] pos) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < station.length; i++) {
            set.add(station[i]);
            map.put(station[i], i);
        }
        int[] res = new int[pos.length];
        for (int i = 0; i < pos.length; i++) {
            int pre = set.lower(pos[i]) == null ? 0 : set.lower(pos[i]);
            int next = set.ceiling(pos[i]) == null ? 0 : set.ceiling(pos[i]);
            if (pre == 0) {
                res[i] = map.get(next);
            }else if (next == 0) {
                res[i] = map.get(pre);
            }else{
                if (next - pos[i]<pos[i]-pre){
                    res[i] = map.get(next);
                }else{
                    res[i] = map.get(pre);
                }
            }
        }
        return res;
    }
}
