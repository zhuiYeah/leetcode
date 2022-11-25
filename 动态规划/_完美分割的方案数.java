package 动态规划;

//将字符串S完美分割成 k 份 ， 每份的长度 最少为 l ， 一共有多少种分割方案

//f[i][j] 表示把 s 的前 j 个字符分割成 i 段的方案数
//累加所有 f[i-1][j']记作 sum，那么 f[i][j]=sum。

//循环优化 20ms + 动态规划
public class _完美分割的方案数 {
    private static final int MOD = (int) 1e9 + 7;

    private boolean isPrime(char c) {
        return c == '2' || c == '3' || c == '5' || c == '7';
    }

    // 判断是否可以在 j-1 和 j 之间分割（开头和末尾也算）
    private boolean canPartition(char[] s, int j) {
        return j == 0 || j == s.length || !isPrime(s[j - 1]) && isPrime(s[j]);
    }

    public int beautifulPartitions(String S, int k, int l) {
        var s = S.toCharArray();
        var n = s.length;
        if (k * l > n || !isPrime(s[0]) || isPrime(s[n - 1])) return 0;
        var f = new int[k + 1][n + 1];
        f[0][0] = 1;//表示空串的 0个分割 算作一种方案

        for (int i = 1; i <= k; i++) {//准备切割出第i个字符串
            int sum = 0;
            //枚举所有的分割点  优化：枚举的起点和终点需要给前后的子串预留出足够的长度
            for (int j = i * l; j + (k - i) * l <= n; j++) {
                sum = (sum + f[i - 1][j - l]) % MOD;
                if (canPartition(s, j)) f[i][j] = sum;
            }
        }
        return f[k][n];
    }
}


//无循环优化，暴力枚举每个 f[i-1][j']计算出 f[i][j] 980ms
class dede {
    private static final int MOD = (int) 1e9 + 7;

    private boolean isPrime(char c) {
        return c == '2' || c == '3' || c == '5' || c == '7';
    }

    // 判断是否可以在 j-1 和 j 之间分割（开头和末尾也算）
    private boolean canPartition(char[] s, int j) {
        return j == 0 || j == s.length || !isPrime(s[j - 1]) && isPrime(s[j]);
    }

    public int beautifulPartitions(String S, int k, int l) {
        var s = S.toCharArray();
        var n = s.length;
        if (k * l > n || !isPrime(s[0]) || isPrime(s[n - 1])) return 0;
        var f = new int[k + 1][n + 1];
        f[0][0] = 1;//表示空串的 0个分割 算作一种方案

        for (int i = 1; i <= k; i++) {//准备切割出第i个字符串
            //枚举所有的分割点j  优化：枚举的起点和终点需要给前(i * l) 后() 的子串预留出足够的长度
            for (int j = i * l; j + (k - i) * l <= n; j++) {
                if (canPartition(s, j)) {
                    int sum = 0;
                    //枚举前一个分割点w的所有可能位置
                    for (int w = (i - 1) * l; w <= j - l; w++) sum = (sum + f[i - 1][w]) % MOD;
                    f[i][j] = sum;
                }
            }
        }
        return f[k][n];
    }
}