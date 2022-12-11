package _周赛;

import java.util.ArrayList;

public class 青蛙过河II {
    public int maxJump(int[] stones) {
        int n = stones.length;
        if (n == 2) return stones[1] - stones[0];
//        int maxInteger = 0;
//        int idx = -1;
//        for (int i = 1; i < n; i++) {
//            if (stones[i] - stones[i - 1] > maxInteger) {
//                maxInteger = stones[i] - stones[i - 1];
//                idx = i;
//            }
////idx和 idx -1 之间的间距是最大间距哦
        var list = new ArrayList<Integer>();
        for (int i = 1; i < n; i++) {
            list.add(stones[i] - stones[i - 1]);
        }
        int max = 0;
        for (int i = 1; i < list.size(); i++) {
            max = Math.max(max, list.get(i) + list.get(i - 1));
        }

        return max;
    }
}
