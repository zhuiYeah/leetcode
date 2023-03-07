package 链蒸蒸简单;

import java.util.Arrays;

public class 装满杯子需要的最短总时长 {
    public int fillCups(int[] amount) {
        int cnt = 0;
        while (amount[0] != 0 && amount[1] != 0 && amount[2] != 0) {
            Arrays.sort(amount);
            amount[2]--;
            amount[1]--;
            cnt++;
        }
        return cnt + Math.max(amount[0], Math.max(amount[1], amount[2]));
    }
}
