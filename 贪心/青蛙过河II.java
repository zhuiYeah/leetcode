package 贪心;

import java.util.ArrayList;

//stones数组严格递增，青蛙跳到n-1再跳回0 ，每个石头只能跳一次，那么青蛙需要的最小代价为多少
//代价指的是 青蛙在跳跃的过程中  ，单次跳跃的最大跨度

// 贪心 + 脑筋急转弯
//卡了一会，想出来了
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
