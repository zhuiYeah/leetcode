package 排序;

import java.util.ArrayList;

public class 全局倒置和局部倒置 {
    int cnt1 = 0;
    int[] nums;

    public boolean isIdealPermutation(int[] nums) {
        int cnt2 = 0;
        this.nums = nums;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) if (nums[i] > nums[i + 1]) cnt2++;
        mergesort(0, n - 1);
        System.out.println(cnt1 + " " + cnt2);
        return cnt1 == cnt2;
    }

    //寻找一个数组中的逆序对的总数
    private void mergesort(int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        mergesort(l, mid);
        mergesort(mid + 1, r);
        var tmp = new ArrayList<Integer>();
        int i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                cnt1 += j - mid - 1;
                tmp.add(nums[i]);
                i++;
            } else {
                tmp.add(nums[j]);
                j++;
            }
        }
        while (i <= mid) {
            cnt1 += j - mid - 1;
            tmp.add(nums[i]);
            i++;
        }
        while (j <= r) {
            tmp.add(nums[j]);
            j++;
        }
        for (i = l; i <= r; i++) nums[i] = tmp.get(i - l);

    }

}


class edfede {
    public static void main(String[] args) {
        var x = new 全局倒置和局部倒置();
        x.isIdealPermutation(new int[]{1, 0, 2});
    }
}
