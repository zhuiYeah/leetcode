package 双指针;

import java.util.ArrayList;
import java.util.List;

//数学 几何 双指针
public class 区间列表的交集 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int m = firstList.length;
        int n = secondList.length;
        int ptrA = 0, ptrB = 0;
        List<int[]> list = new ArrayList<int[]>();
        while (ptrA < m && ptrB < n) {
            int left = Math.max(firstList[ptrA][0], secondList[ptrB][0]);
            int right;
            if (firstList[ptrA][1] < secondList[ptrB][1]) {
                right = firstList[ptrA][1];
                ptrA++;
            } else if (firstList[ptrA][1] > secondList[ptrB][1]) {
                right = secondList[ptrB][1];
                ptrB++;
            } else {
                right = firstList[ptrA][1];
                ptrA++;
                ptrB++;
            }
            if (left <= right) {
                list.add(new int[]{left, right});
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
