package 排序;

import java.util.ArrayList;

// 归并排序 + 分治
public class 数组中的逆序对 {
    int[] nums;

    public int reversePairs(int[] nums) {
        this.nums = nums;
        return mergesort(0, nums.length - 1);
    }

    private int mergesort(int l, int r) {
        if (l >= r) return 0;
        int mid = l + (r - l) / 2;
        int res = mergesort(l, mid) + mergesort(mid + 1, r);
        var tmp = new ArrayList<Integer>();
        int i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                res += j - mid - 1;
                tmp.add(nums[i]);
                i++;
            } else {
                tmp.add(nums[j]);
                j++;
            }
        }
        while (i <= mid) {
            res += j - mid - 1;
            tmp.add(nums[i]);
            i++;
        }
        while (j <= r) {
            tmp.add(nums[j]);
            j++;
        }
        for (i = l; i <= r; i++) {
            nums[i] = tmp.get(i - l);
        }
        return res;
    }
}


///另一种写法，维护一个全局变量 res
class dede {
    int[] nums;
    int res = 0;

    public int reversePairs(int[] nums) {
        this.nums = nums;
        mergesort(0, nums.length - 1);
        return res;
    }

    private void mergesort(int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        mergesort(l, mid);
        mergesort(mid + 1, r);
        var tmp = new ArrayList<Integer>();
        int i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                res += j - mid - 1;
                tmp.add(nums[i]);
                i++;
            } else {
                tmp.add(nums[j]);
                j++;
            }
        }
        while (i <= mid) {
            res += j - mid - 1;
            tmp.add(nums[i]);
            i++;
        }
        while (j <= r) {
            tmp.add(nums[j]);
            j++;
        }
        for (i = l; i <= r; i++) {
            nums[i] = tmp.get(i - l);
        }
    }
}