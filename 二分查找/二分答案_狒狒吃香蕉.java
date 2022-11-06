package 二分查找;

import java.util.Arrays;

//剑指offer
public class 二分答案_狒狒吃香蕉 {
    int h;
    int[] piles;

    public int minEatingSpeed(int[] piles, int h) {
        this.h = h;
        //Arrays.sort(piles);
        this.piles = piles;
        int left = 1, right = 1000000000;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canIEat(mid)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    public boolean canIEat(int k) {
        int resth = h;
        for (int i = piles.length - 1; i >= 0; i--) {
            if (piles[i] % k == 0) {
                resth -= piles[i] / k;
            } else {
                resth -= piles[i] / k + 1;
            }
            if (resth < 0) return false;
        }
        return true;
    }
}
