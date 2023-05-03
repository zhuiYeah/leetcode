package 链蒸蒸简单;

import java.util.Arrays;

public class 移动石子直到连续 {
    public int[] numMovesStones(int a, int b, int c) {
        int[] stones = new int[]{a, b, c};
        Arrays.sort(stones);
        a = stones[0];
        b = stones[1];
        c = stones[2];
        if (b - a == 1 && c - b == 1) return new int[]{0, 0};
        if (b - a == 1) return new int[]{1, c - b - 1};
        if (c - b == 1) return new int[]{1, b - a - 1};
        if (b - a == 2) return new int[]{1, 1 + c - b - 1};
        if (c - b == 2) return new int[]{1, 1 + b - a - 1};
        return new int[]{2, c - b - 1 + b - a - 1};
    }
}
