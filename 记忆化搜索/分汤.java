package 记忆化搜索;

//有 A 和 B 两种类型 的汤。一开始每种类型的汤有 n 毫升。有四种分配操作：
//
//提供 100ml 的 汤A 和 0ml 的 汤B 。
//提供 75ml 的 汤A 和 25ml 的 汤B 。
//提供 50ml 的 汤A 和 50ml 的 汤B 。
//提供 25ml 的 汤A 和 75ml 的 汤B 。

//需要返回的值： 汤A 先分配完的概率 +  汤A和汤B 同时分配完的概率 / 2。返回值在正确答案 10-5 的范围内将被认为是正确的。

import java.util.HashMap;
import java.util.Map;

//全概率公式 + 记忆化搜索
public class 分汤 {
    public double soupServings(int n) {
        if (n >= 5000) return 1;
        return dfs(n, n);
    }

    private Map<String, Double> memo = new HashMap<String, Double>();

    //A有aml，B有bml，返回 A先分配完的概率 + A、B同时分配完的概率/2 ，将其称之为事件
    private double dfs(int a, int b) {
        if (a == 0 && b != 0) return 1;
        if (a == 0 && b == 0) return 0.5;
        if (a != 0 && b == 0) return 0;

        //记忆化
        var s = new String(a + "-" + b);
        if (memo.containsKey(s)) return memo.get(s);

        //全概率公式
        double possab = 0;
        possab += dfs(Math.max(a - 100, 0), b); //进行操作1能得到事件的概率
        possab += dfs(Math.max(a - 75, 0), Math.max(b - 25, 0)); //进行操作2能得到事件的概率
        possab += dfs(Math.max(a - 50, 0), Math.max(b - 50, 0));
        possab += dfs(Math.max(a - 25, 0), Math.max(b - 75, 0));
        possab /= 4;
        memo.put(s, possab);
        return possab;
    }
}
