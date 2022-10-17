package 递归;

public class Pow_x_n {
    public double myPow(double x, int n) {
        if (n < 0) return 1 / help(x, -n);
        return help(x, n);
    }

    public double help(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double yinZi = help(x, n / 2);
        if (n % 2 != 0) return yinZi * yinZi * x;
        return yinZi * yinZi;
    }
}
