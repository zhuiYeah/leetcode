package 字典树;

//int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。

import java.util.HashMap;
import java.util.Map;

public class 键值映射 {

}


class MapSum {
    MapSum[] children;
    int val;
    Map<String, Integer> map = new HashMap<>();

    public MapSum() {
        children = new MapSum[26];
        val = 0;
    }

    public void insert(String key, int val) {
        int tmp =val;
        if (map.containsKey(key)) {
            val = val - map.get(key);
        }
        map.put(key, tmp);
        var node = this;
        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (node.children[index] == null) node.children[index] = new MapSum();
            node = node.children[index];
            node.val += val;
        }
    }

    public int sum(String prefix) {
        var node = this;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.children[index] == null) return 0;
            node = node.children[index];
        }
        return node.val;
    }
}

class test {
    public static void main(String[] args) {
        var node = new MapSum();
        node.insert("apple", 3);
        node.insert("app", 2);

    }
}