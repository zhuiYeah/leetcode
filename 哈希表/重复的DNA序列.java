package 哈希表;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//列出所有的重复的长度为10的子串
public class 重复的DNA序列 {
    public List<String> findRepeatedDnaSequences(String s) {
        int start = 0 , end = 10;
        List<String> res = new ArrayList<String>();
        if (s.length() <11)  return res;
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for (start = 0; end <= s.length(); end++,start++) {
            var now = s.substring(start, end);
            map.put(now,map.getOrDefault(now,0)+1);
        }
        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            if (entry.getValue()>=2){
                res.add(entry.getKey());
            }
        }
        return res;
    }
}
