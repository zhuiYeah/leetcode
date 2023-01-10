package 模拟;

import java.util.Arrays;

//根据题意模拟即可
public class 还原排列的最少操作步数 {
    public int reinitializePermutation(int n) {
        int[] premInit = new int[n];
        for (int i = 0; i < n; i++) premInit[i] = i;
        int[] prem = Arrays.copyOf(premInit, n);
        int cnt = 0;
        do {
            cnt++;
            var arr = new int[n];
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    arr[i] = prem[i / 2];
                } else {
                    arr[i] = prem[n / 2 + (i - 1) / 2];
                }
            }
            prem = arr;
        } while (!isEqual(prem, premInit));
        return cnt;
    }

    private boolean isEqual(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++)
            if (a[i] != b[i]) return false;

        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        var arrcopy = Arrays.copyOf(arr, arr.length);
        arr[0] = 99999;
        System.out.println(Arrays.toString(arrcopy));
    }
}
