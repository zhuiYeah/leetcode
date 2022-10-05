package 哈希表;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//利用哈希表进行模拟即可
public class 子域名访问计数 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String s : cpdomains) {
            var ss = s.split(" ");
            int count = Integer.parseInt(ss[0]);
            var domain = ss[1];
            domain = '.' + domain;
            for (int i = 0; i < domain.length(); i++) {
                if (domain.charAt(i) == '.') {
                    var sub = domain.substring(i + 1);
                    map.put(sub, map.getOrDefault(sub, 0) + count);
                }
            }
        }
        var res = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            var count = entry.getValue();
            var domain = entry.getKey();
            res.add(count + " " + domain);
        }
        return res;
    }
}
