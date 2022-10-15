package 贪心;

//给定一个整数n，找到重新排列这个整数的 各个位 之后的下一个更大元素 ，如果找不到 返回-1

import java.util.ArrayList;

//贪心 ，找到最靠后的相对较大的数字， 和这个大数字之前的最靠后的相对较小的数字  进行交换
//看我的题解把
public class 下一个更大元素III {
    public static int nextGreaterElement(int n) {
        var num = String.valueOf(n);
        int bigIndex = -1;
        int smallIndex = -1;
        for (int i = num.length() - 1; i > 0; i--) {
            if (num.charAt(i) > num.charAt(i - 1)) {
                smallIndex = i - 1;
                bigIndex = i;
                break;
            }
        }
        if (bigIndex == -1) return -1;
        for (int i = bigIndex + 1; i < num.length(); i++) {
            if (num.charAt(i) > num.charAt(smallIndex)) {
                bigIndex = i;
            }
        }
        var numc = num.toCharArray();
        var tmp = numc[bigIndex];
        numc[bigIndex] = numc[smallIndex];
        numc[smallIndex] = tmp;
        mergeSort(numc, smallIndex + 1, numc.length - 1);
        num = new String(numc);
        long res = Long.parseLong(num);
        if (res > Integer.MAX_VALUE) return -1;
        return (int) res;
    }

    public static void mergeSort(char[] nums, int start, int end) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        int i = start, j = mid + 1;
        var tmp = new ArrayList<Character>();
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
        for (i = start; i <= end; i++) {
            nums[i] = tmp.get(i - start);
        }
    }

    public static void main(String[] args) {
        nextGreaterElement(230241);
    }
}
