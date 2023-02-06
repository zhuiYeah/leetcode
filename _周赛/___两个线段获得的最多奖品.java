package _周赛;

import java.util.HashMap;
/**
 * 周赛T3
 * 有一个单调不减的数组，
 * 现在你从数组中取出两段 （两段可以重叠）
 * 每一段的 两个端点的差 最大为k
 *
 * 给出这两个线段的最大长度
 */


public class ___两个线段获得的最多奖品 {
    public int maximizeWin(int[] prizePositions, int k) {
        int n = prizePositions.length;
        int len = prizePositions[n - 1] - prizePositions[0]; //线段总长度
        int min = prizePositions[0], max = prizePositions[n - 1];
        var map = new HashMap<Integer, Integer>();
        for (int i : prizePositions) map.put(i, map.getOrDefault(i, 0) + 1);

        return 0;


    }
}
