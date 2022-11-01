package 哈希表;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//来自317场周赛 ， wa 一次
public class 最流行的视频创作者 {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        List<List<String>> res = new ArrayList<>();
        int n = creators.length;
        long  max = 0;
        Map<String, Long> cre2total = new HashMap<>();//作者 -> 总播放量
        Map<String, Integer> cre2onemax = new HashMap<>(); //作者 -> 单个视频最大播放量
        Map<String, String> cre2themaxViedo = new HashMap<>(); //作者 -> 播放量最大视频的名称ids
        for (int i = 0; i < n; i++) {
            cre2total.put(creators[i], cre2total.getOrDefault(creators[i], 0L) + views[i]);
            max = Math.max(max, cre2total.get(creators[i]));
            int onemax = cre2onemax.getOrDefault(creators[i], -1);
            if (views[i] > onemax) {
                cre2onemax.put(creators[i], views[i]);
                cre2themaxViedo.put(creators[i], ids[i]);
            } else if (views[i] == onemax) {
                String idold = cre2themaxViedo.get(creators[i]);
                if (xxxx(ids[i], idold)) {
                    cre2themaxViedo.put(creators[i], ids[i]);
                }
            }
        }
        for (Map.Entry<String, Long> entry : cre2total.entrySet()) {
            if (entry.getValue() == max) {
                var list = new ArrayList<String>();
                list.add(entry.getKey());
                list.add(cre2themaxViedo.get(entry.getKey()));
                res.add(list);
            }
        }
        return res;
    }

    //s1的字典序是否更小
    public boolean xxxx(String s1, String s2) {
        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            if (s1.charAt(i) < s2.charAt(i)) {
                return true;
            } else if (s1.charAt(i) > s2.charAt(i)) {
                return false;
            }
        }
        return s1.length() < s2.length();
    }
}
