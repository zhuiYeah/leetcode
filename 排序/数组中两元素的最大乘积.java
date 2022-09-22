package 排序;

import java.util.*;

public class 数组中两元素的最大乘积 {


    public int maxProduct(int[] nums) {
        int n = nums.length;
        mergeSort(nums, 0, n - 1);
        //Arrays.sort(nums);

        return (nums[n - 1] - 1) * (nums[n - 2] - 1);
    }

    public void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        int i = start, j = mid + 1;
        List<Integer> tmp = new ArrayList<Integer>();
        while (i <= mid && j <= end) {
            if (nums[i] < nums[j]) {
                tmp.add(nums[i]);
                i++;
            } else {
                tmp.add(nums[j]);
                j++;
            }
        }
        while (i <= mid) {
            tmp.add(nums[i]);
            i++;
        }
        while (j <= end) {
            tmp.add(nums[j]);
            j++;
        }
        for (int k = start; k <= end; k++) {
            nums[k] = tmp.get(k - start);
        }
    }

}


//////////////////////////////////////////////////////////////////////////////////////////////////////
class 一次遍历 {
    public int maxProduct(int[] nums) {
        int max1 = -1;
        int max2 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > Math.min(max1, max2)) {
                if (max1 < max2) {
                    max1 = nums[i];
                } else {
                    max2 = nums[i];
                }
            }
        }
        return (max1-1) * (max2-1);
    }
}