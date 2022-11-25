package 记忆化搜索;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 将整数按权重排序 {
    private Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public int getKth(int lo, int hi, int k) {
        memo.put(1, 0);
        var list = new ArrayList<Integer>();
        for (int i = lo; i <= hi; i++) {
            dfs(i);
            list.add(i);
        }
        list.sort((a, b) -> {
            if (memo.get(a) == memo.get(b)) return a - b;
            else return memo.get(a) - memo.get(b);
        });
        return list.get(k - 1);
    }

    //返回数字n的权重
    private int dfs(int n) {
        if (memo.containsKey(n)) return memo.get(n);
        if (n % 2 == 0) memo.put(n, dfs(n / 2) + 1);
        else memo.put(n, (dfs(3 * n + 1) + 1));
        return memo.get(n);
    }
}
