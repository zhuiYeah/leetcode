package 记忆化搜索;

public class _不同骰子序列的数目 {
    final int MOD = (int) 1e9 + 7;
    int N;
    long[][][] f; //f[i][j][k]：从 i位置开始，i位置的前一个数是j，前前个数是k， 从i位置算起到结尾的不同骰子序列数为 f[i][j][k]

    public int distinctSequences(int n) {
        N = n;
        f = new long[n + 1][8][8];
        return (int) f(0, 7, 7);
    }

    private long f(int i, int j, int k) {
        if (i == N) return 1; //边界条件 ，已经越界了
        if (f[i][j][k] != 0) return f[i][j][k];
        long res = 0;
        for (int x = 1; x <= 6; x++) {
            //枚举的x满足前面两个数的限制，往右继续搜
            if (x != j && x != k && gcd(x, j) == 1) {
                res = (res + f(i + 1, x, j)) % MOD;
            }
        }
        f[i][j][k] = res;
        return res;
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
