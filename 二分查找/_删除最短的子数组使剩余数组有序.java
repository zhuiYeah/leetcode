package 二分查找;

public class _删除最短的子数组使剩余数组有序 {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int i = 1;
        while (i < n && arr[i - 1] <= arr[i]) i++;
        if (i == n) return 0; //本身就已经递增了
        int j = n - 1;
        while (j - 1 >= 0 && arr[j - 1] <= arr[j]) j--;
        //从 [0,i) 是满足单调递增  [j,n)满足胆小递增
        //枚举 [0,i)范围内的所有点作为l ， 找到[j,n)内的第一个r 使得  arr[r] >= arr[l]
        int res = j; //最坏情况删除 [0~j-1] 共j个点
        for (int l = 0; l < i; l++) {
            int num = arr[l];
            int left = j, right = n - 1; //找到其中第一个大于等于 num的下标
            int r = n;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] >= num) {
                    r = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            res = Math.min(res, r - l - 1);
        }
        return res;
    }
}
