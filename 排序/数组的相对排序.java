package 排序;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 数组的相对排序 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }

        Integer[] aa = new Integer[arr1.length];
        for (int i = 0; i < aa.length; i++) aa[i] = arr1[i];

        Arrays.sort(aa, (a, b) -> {
            return map.getOrDefault(a, 1000+a) - map.getOrDefault(b, 1000+b);
        });
        for (int i = 0; i < aa.length; i++) arr1[i] = aa[i];
        return arr1;
    }
}
