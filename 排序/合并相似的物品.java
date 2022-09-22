package 排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 合并相似的物品 {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> result = new ArrayList<>();
        mergeSort(items1, 0, items1.length - 1);
        mergeSort(items2, 0, items2.length - 1);
        int ptr1 = 0, ptr2 = 0;
        while (ptr1 < items1.length && ptr2 < items2.length) {
            ArrayList<Integer> x = new ArrayList<>();
            if (items1[ptr1][0] == items2[ptr2][0]) {
                x.add(items1[ptr1][0]);
                x.add(items1[ptr1][1] + items2[ptr2][1]);
                ptr1++;
                ptr2++;
            } else if (items1[ptr1][0] > items2[ptr2][0]) {
                x.add(items2[ptr2][0]);
                x.add(items2[ptr2][1]);
                ptr2++;
            } else {
                x.add(items1[ptr1][0]);
                x.add(items1[ptr1][1]);
                ptr1++;
            }
            result.add(x);
        }
        while (ptr1 < items1.length) {
            ArrayList<Integer> x = new ArrayList<>();
            x.add(items1[ptr1][0]);
            x.add(items1[ptr1][1]);
            result.add(x);
            ptr1++;
        }
        while (ptr2 < items2.length) {
            ArrayList<Integer> x = new ArrayList<>();
            x.add(items2[ptr2][0]);
            x.add(items2[ptr2][1]);
            result.add(x);
            ptr2++;
        }

        return result;
    }

    public void mergeSort(int[][] items, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(items, start, mid);
        mergeSort(items, mid + 1, end);
        int i = start, j = mid + 1;
        ArrayList<int[]> tmp = new ArrayList<>();
        while (i <= mid && j <= end) {
            if (items[i][0] < items[j][0]) {
                tmp.add(items[i]);
                i++;
            } else {
                tmp.add(items[j]);
                j++;
            }
        }
        while (i <= mid) {
            tmp.add(items[i]);
            i++;
        }
        while (j <= end) {
            tmp.add(items[j]);
            j++;
        }
        for (int k = start; k <= end; k++) {
            items[k] = tmp.get(k - start);
        }
    }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////
//库函数排序
class Solution1 {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Arrays.sort(items1, new Comparator<int[]>() { //自定排序规则
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        });
        Arrays.sort(items2, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        });
        List<List<Integer>> result = new ArrayList<>();
        int ptr1 = 0, ptr2 = 0;
        while (ptr1 < items1.length && ptr2 < items2.length) {
            ArrayList<Integer> x = new ArrayList<>();
            if (items1[ptr1][0] == items2[ptr2][0]) {
                x.add(items1[ptr1][0]);
                x.add(items1[ptr1][1] + items2[ptr2][1]);
                ptr1++;
                ptr2++;
            } else if (items1[ptr1][0] > items2[ptr2][0]) {
                x.add(items2[ptr2][0]);
                x.add(items2[ptr2][1]);
                ptr2++;
            } else {
                x.add(items1[ptr1][0]);
                x.add(items1[ptr1][1]);
                ptr1++;
            }
            result.add(x);
        }
        while (ptr1 < items1.length) {
            ArrayList<Integer> x = new ArrayList<>();
            x.add(items1[ptr1][0]);
            x.add(items1[ptr1][1]);
            result.add(x);
            ptr1++;
        }
        while (ptr2 < items2.length) {
            ArrayList<Integer> x = new ArrayList<>();
            x.add(items2[ptr2][0]);
            x.add(items2[ptr2][1]);
            result.add(x);
            ptr2++;
        }

        return result;

    }
}
