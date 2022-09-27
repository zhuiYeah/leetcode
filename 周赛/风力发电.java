package 周赛;

//读懂题意后模拟即可
//2022 9.16中国银联
public class 风力发电 {
    public int storedEnergy(int storeLimit, int[] power, int[][] supply) {
        int n = supply.length;
        int store = 0;
        int min = supply[0][1];
        int max = supply[0][2];
        int nextChangeTime = -1;
        int nextPtr = -1;
        if (supply.length != 1) {
            nextChangeTime = supply[1][0];
            nextPtr = 1;
        }
        for (int i = 0; i < power.length; i++) {
            if (i == nextChangeTime) {
                min = supply[nextPtr][1];
                max = supply[nextPtr][2];
                nextPtr++;
                if (nextPtr >= n) {
                    nextChangeTime = -1;
                } else {
                    nextChangeTime = supply[nextPtr][0];
                }
            }
            if (power[i] > max) {
                store = Math.min(storeLimit, store + power[i] - max);
            } else if (power[i] < min) {
                store = Math.max(0, store - (min - power[i]));
            }
        }
        return store;
    }
}
