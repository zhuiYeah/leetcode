package 链蒸蒸简单;

public class 找出中枢整数 {
    public int pivotInteger(int n) {
        int x = n * (n + 1) / 2;
        int l = 1, r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid > x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
