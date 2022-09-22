package 二分查找;

//注意long要显式转换
//看来go的int要比java的int大很多
public class x的平方根 {
    public int mySqrt(int x) {
        int left = 0, right = x;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long tmp = (long) mid * mid;
            if (tmp > x) {
                right = mid - 1;
            } else {
                res = mid;
                left = mid + 1;
            }
        }
        return res;
    }
}
