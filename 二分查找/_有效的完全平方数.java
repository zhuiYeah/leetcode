package 二分查找;

//给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
//不可以使用库函数哦
//二分查找
//----------------------------------------------------------------
//超时的二分查找
//将x的数据类型由int变为long之后，直接0ms通过了
//太傻逼了
public class _有效的完全平方数 {
    public boolean isPerfectSquare(int num) {
        int left = 1, right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long x = (long) mid * mid;
            if (x == num) {
                return true;
            } else if (x > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
