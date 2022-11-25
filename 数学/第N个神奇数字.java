package 数学;


//主要是数学

//f(x) 表示为小于等于 x 的「神奇数字」个数
//f(x)= x/a + x/b - x/c;
public class 第N个神奇数字 {
    static final int MOD = 1000000007;

    public int nthMagicalNumber(int n, int a, int b) {
        long l = 1;
        long r = Long.MAX_VALUE;
        int c = lcm(a, b);
        long res = -1;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long cnt = mid / a + mid / b - mid / c; //小于等于mid的神奇数字一共有cnt个
            if (cnt >= n) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) ((res) % MOD);
    }

    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private int gcd(int a, int b) {
        while (a % b != 0) {
            var tmp = a % b;
            a = b;
            b = tmp;
        }
        return b;
    }
}
