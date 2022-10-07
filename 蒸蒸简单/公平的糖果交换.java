package 蒸蒸简单;

import java.util.HashSet;
import java.util.Set;

public class 公平的糖果交换 {
    Set<Integer> alice = new HashSet<Integer>();
    Set<Integer> bob = new HashSet<Integer>();

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceSum = 0;
        int bobSum = 0;
        for (int i = 0; i < aliceSizes.length; i++) {
            aliceSum += aliceSizes[i];
            alice.add(aliceSizes[i]);
        }
        for (int i = 0; i < bobSizes.length; i++) {
            bobSum += bobSizes[i];
            bob.add(bobSizes[i]);
        }
        int changeDifference = (aliceSum - bobSum) / 2;
        for (Integer set : alice) {
            if (bob.contains(set - changeDifference)) {
                return new int[]{set, set - changeDifference};
            }
        }
        return null;
    }
}
