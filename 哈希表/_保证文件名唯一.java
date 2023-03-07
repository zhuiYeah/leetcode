package 哈希表;

import java.util.HashMap;
import java.util.Map;

//维护一个最小计数太复杂，错误
//public class 保证文件名唯一 {
//    Map<String, Integer> map = new HashMap<>();//如果我要使用 名字 hegang 并且 map.get(hegang)==1 ，那么最小计数就是 hegang（1）
//
//    public String[] getFolderNames(String[] names) {
//        var res = new String[names.length];
//        var i = -1;
//        for (String name : names) {
//            i++;
//            //如果map不存在该name的映射 那么就一定可以直接使用
//            if (!map.containsKey(name)) {
//                res[i] = name;
//                map.put(name, 1); //之后如果再出现同名的name，那么就会成为name(1)
//                int cnt = 1;
//                while (map.containsKey(name + "(" + cnt + ")")) cnt++;
//                map.put(name, cnt);
//                if (name.contains("(")) {
//                    //例如 s 的最小计数为2，而name恰好为s（2），那么就需要更新这个最小计数为3
//                    //如果name为s（3），那么不需要更新这个最小计数
//                    renew(name);
//                }
//                continue;
//            }
//            //存在该name映射，那么该映射就是最小下标
//            var newS = name + "(" + map.get(name) + ")";
//            res[i] = newS;
//            map.put(newS, 1);
//            int idx = map.get(name) + 1;
//            while (map.containsKey(name + "(" + idx + ")")) idx++;
//            map.put(name, idx);
//        }
//        return res;
//    }
//
//    private void renew(String name) {
//        var father = change(name);
//        if (!map.containsKey(father)) return;
//        int cnt = map.get(father);
//        int nameIdx = Integer.parseInt(name.substring(father.length() + 1, name.length() - 1));
//        if (cnt != nameIdx) return;
//        var sb = new String(father);
//        while (map.containsKey(father + "(" + cnt + ")")) {
//            cnt++;
//        }
//        map.put(father, cnt);
//    }
//
//    //a(x)(x)(x) -> a(x)(x) ：相当于去除最后一个括号
//    private String change(String s) {
//        int i = s.length() - 1;
//        for (; i >= 0; i--) {
//            if (s.charAt(i) == '(') break;
//        }
//        return s.substring(0, i);
//    }
//}
//
////直接狠狠暴力,超时
//class fdr {
//    Map<String, Integer> map = new HashMap<String, Integer>(); //映射name的下一后缀序号
//
//    public String[] getFolderNames(String[] names) {
//        var res = new String[names.length];
//        for (int i = 0; i < names.length; i++) {
//            String name = names[i];
//            if (!map.containsKey(name)) {
//                res[i] = name;
//                if (name.contains("(")) renew(name);
//                int idx = 1;
//                while (map.containsKey(name + "(" + idx + ")")) idx++;
//                map.put(name, idx);
//                continue;
//            }
//            int idx = map.get(name);
//            res[i] = name + "(" + idx + ")";
//            map.put(name + "(" + idx + ")", 1);
//            while (map.containsKey(name + "(" + idx + ")")) idx++;
//            map.put(name, idx);
//        }
//        return res;
//    }
//
//    private void renew(String name) {
//        var father = change(name);
//        if (!map.containsKey(father)) return;
//        int cnt = map.get(father);
//        int nameIdx = Integer.parseInt(name.substring(father.length() + 1, name.length() - 1));
//        if (cnt != nameIdx) return;
//        var sb = new String(father);
//        while (map.containsKey(father + "(" + cnt + ")")) {
//            cnt++;
//        }
//        map.put(father, cnt);
//    }
//
//    private String change(String s) {
//        int i = s.length() - 1;
//        for (; i >= 0; i--) {
//            if (s.charAt(i) == '(') break;
//        }
//        return s.substring(0, i);
//    }
//}

class Solution {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> index = new HashMap<String, Integer>();
        int n = names.length;
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            String name = names[i];
            if (!index.containsKey(name)) {
                res[i] = name;
                index.put(name, 1);
            } else {
                int k = index.get(name);
                while (index.containsKey(addSuffix(name, k))) k++;
                res[i] = addSuffix(name, k);
                index.put(name, k + 1);
                index.put(addSuffix(name, k), 1);
            }
        }
        return res;
    }

    public String addSuffix(String name, int k) {
        return name + "(" + k + ")";
    }
}

class Solutio1n {
    public String[] getFolderNames(String[] names) {
        var index = new HashMap<String, Integer>();//记录以name作为前缀的可能的最小下标，可能存在重复
        var res = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (!index.containsKey(name)) {
                res[i] = name;
                index.put(name, 1);
                continue;
            }
            int idx = index.get(name);//这个最小下标不一定真的可以用
            while (index.containsKey(name + "(" + idx + ")")) idx++;
            res[i] = name + "(" + idx + ")";
            index.put(name, idx + 1);
            index.put(name + "(" + idx + ")", 1);
        }
        return res;
    }
}
