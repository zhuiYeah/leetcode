package 链蒸蒸简单;

public class 最小偶倍数 {
    public static void main(String[] args) {
    }


    // 计算 2 与 n 的最小公倍数
    public int smallestEvenMultiple(int n) {
        return 2 * n / gcd(2, n);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}
