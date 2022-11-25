package 记忆化搜索;

import java.util.HashMap;
import java.util.Map;

//记忆化搜索
class edede {
    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public int minDays(int n) {
        if (n <= 1) return n;
        if (memo.containsKey(n)) return memo.get(n);
        int min = Integer.MAX_VALUE;
        //需要n%2天单独吃1个 才能能吃成2的倍数
        min = Math.min(min, minDays(n / 2) + n % 2);
        //需要n%3天单独吃1个 才能能吃成三的倍数
        min = Math.min(min, minDays(n / 3) + n % 3);

        min++;
        memo.put(n, min);
        return min;
    }
}

//超时 由于递归中存在 f（n-1），这是 O（n）复杂度
public class _吃掉n个橘子的最少天数 {
    private Map<Integer, Integer> memo;

    public int minDays(int n) {
        memo = new HashMap<>();
        return f(n);
    }

    public int f(int n) {
        if (n == 3 || n == 2) return 2;
        if (n == 1) return 1;
        if (memo.containsKey(n)) return memo.get(n);

        int one = Integer.MAX_VALUE;
        int two = Integer.MAX_VALUE;
        if (n % 3 == 0) one = f(n / 3);
        if (n % 2 == 0) two = f(n / 2);
        int three = f(n - 1);
        memo.put(n, Math.min(one, Math.min(three, two)) + 1);
        return memo.get(n);
    }

}


class defd {
    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public int minDays(int n) {
        if (n <= 1) return n;
        if (memo.containsKey(n)) return memo.get(n);
        memo.put(n, Math.min(n % 2 + 1 + minDays(n / 2), n % 3 + 1 + minDays(n / 3)));
        return memo.get(n);
    }
}

