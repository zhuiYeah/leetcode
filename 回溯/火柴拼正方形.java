package 回溯;

import java.util.Arrays;
import java.util.OptionalInt;

public class 火柴拼正方形 {
    int[] matchsticks;
    int n;
    int[] buckets;

    public boolean makesquare(int[] matchsticks) {
        int cap = Arrays.stream(matchsticks).sum();
        if (cap % 4 != 0) return false;
        cap /= 4;
        Arrays.sort(matchsticks);
        n = matchsticks.length;
        this.matchsticks = matchsticks;
        //一共有4个桶，火柴能否恰好全部装满这些桶
        buckets = new int[4];
        Arrays.fill(buckets, cap);
        return backtracking(n - 1);
    }

    //curIndex 表示当前火柴的下标，我们决定从最大的火柴开始装起
    public boolean backtracking(int cur) {
        if (cur == -1) return true;
        for (int i = 0; i < 4; i++) {
            if (buckets[i] > matchsticks[cur] && buckets[i] - matchsticks[cur] >= matchsticks[0] || buckets[i] == matchsticks[cur]) {
                buckets[i] -= matchsticks[cur];
                if (backtracking(cur - 1)) return true;
                buckets[i] += matchsticks[cur];
            }
        }
        return false;
    }
}
