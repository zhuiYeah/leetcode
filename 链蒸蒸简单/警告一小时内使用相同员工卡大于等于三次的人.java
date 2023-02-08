package 链蒸蒸简单;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 警告一小时内使用相同员工卡大于等于三次的人 {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        int n = keyName.length;
        int[] time = new int[n];
        for (int i = 0; i < keyTime.length; i++) {
            var s = keyTime[i].split(":");
            int num = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
            time[i] = num;
        }
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> time[a] - time[b]);
        var map = new HashMap<String, ArrayList<Integer>>();
        for (int i : idx) {
            var name = keyName[i];
            var theTime = time[i];
            var list = map.getOrDefault(name, new ArrayList<Integer>());
            list.add(theTime);
            map.put(name, list);
        }
        var res = new ArrayList<String>();
        for (HashMap.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() < 3) continue;
            var list = entry.getValue();
            var flag = false;
            for (int i = 2; i < list.size(); i += 2) {
                if (list.get(i) - list.get(i - 2) <= 60) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                res.add(entry.getKey());
                continue;
            }
            for (int i = 3; i < list.size(); i += 2) {
                if (list.get(i) - list.get(i - 2) <= 60) {
                    flag = true;
                    break;
                }
            }
            if (flag) res.add(entry.getKey());
        }
        res.sort((a,b)-> a.compareTo(b));  //结果按字典序升序
        return res;
    }
}
