package 双指针;

import java.util.*;

//arr是一个已经排序的数组，找到其中最接近x的k个元素
public class 找到k个最接近的元素 {
    int destination;

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        destination = x;
        int start = 0;
        int end = k - 1;
        for (int i = k; i < arr.length; i++) {
            if (compare(arr[start], arr[i])) {
                break;
            } else {
                start++;
                end++;
            }
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i = start; i <= end; i++) {
            result.add(arr[i]);
        }
        return result;
    }

    public boolean compare(int a, int b) { //这里a必定小于等于b ， 判断a是否更接近destination
        if (a == b) { //如果a b相等，那么必须要移动窗口了，因为目前窗口内的元素可能都是比较远的，不能鼠目寸光
            return false;
        }
        return Math.abs(a - destination) <= Math.abs(b - destination);
    }
}
