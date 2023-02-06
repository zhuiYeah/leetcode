package 链蒸蒸简单;

import java.util.HashSet;

public class 从一个范围内选择最多整数I {
    public int maxCount(int[] banned, int n, int maxSum) {
        var ban = new HashSet<Integer>();
        for (int i : banned) ban.add(i);
        int sum = 0;
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (ban.contains(i)) continue;
            if (sum + i > maxSum) break;
            cnt++;
            sum += i;
        }
        return cnt;
    }
}
