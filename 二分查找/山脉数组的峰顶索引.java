package 二分查找;

//剑指offer

//找到 arr[mid] > arr[mid + 1]的最小mid
public class 山脉数组的峰顶索引 {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int left = 1, right = n - 1, ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid + 1]) {
                ans = mid;
                right = mid - 1;
            } else {
                //ans = mid + 1; 加不加这行都行
                left = mid + 1;
            }
        }
        return ans;
    }
}
