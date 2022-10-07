package 蒸蒸简单;

import java.util.ArrayList;
import java.util.Arrays;

//给你一个整数数组 arr ，请你删除最小 5% 的数字和最大 5% 的数字后，剩余数字的平均值。
//自己写归并排序4ms
public class 删除某些元素后的数组均值 {
    int N;
    int[] arr;

    public double trimMean(int[] arr) {
        N = arr.length;
        this.arr = arr;
        mergeSort(0, N - 1);
        int x = (int) (N * 0.05);
        int sum = 0;
        for (int i = x; i < N - x; i++) {
            sum += arr[i];
        }
        return (double) sum / (N - 2 * x);
    }

    public void mergeSort(int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);
        int i = start, j = mid + 1;
        var tmp = new ArrayList<Integer>();
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                tmp.add(arr[i]);
                i++;
            } else {
                tmp.add(arr[j]);
                j++;
            }
        }
        while (i <= mid) {
            tmp.add(arr[i]);
            i++;
        }
        while (j <= end) {
            tmp.add(arr[j]);
            j++;
        }
        for (i = start; i <= end; i++) {
            arr[i] = tmp.get(i - start);
        }
    }
}

////////////////////////////////
//系统排序api 2ms
class dwd {
    public double trimMean(int[] arr) {
        int N = arr.length;
        Arrays.sort(arr);
        int x = (int) (N * 0.05);
        int sum = 0;
        for (int i = x; i < N - x; i++) {
            sum += arr[i];
        }
        return (double) sum / (N - 2 * x);
    }
}
