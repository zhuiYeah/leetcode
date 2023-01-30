package 数学;

/**
 * 写一个函数，计算    2^n - 2
 * n 最大达到 10^9
 */


//t2  递归实现快速幂
public class __猴子碰撞的方法数 {

    private static final int MOD = (int) (1e9 + 7);

    public int monkeyMove(int n) {
        return ((int) quickE(2, n) - 2 + MOD) % MOD;
    }

    private long quickE(int x, int n) {
        if (n == 1) return x;
        long half = quickE(x, n / 2);
        return (n % 2 == 0 ? half * half : half * half * x) % MOD;
    }

}
