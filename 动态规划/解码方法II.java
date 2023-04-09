package 动态规划;

public class 解码方法II {
    static final int MOD = (int) (1e9 + 7);

    public int numDecodings(String s) {
        var arr = s.toCharArray();
        int n = arr.length;
        //dp[i]:以i为结尾的总解码方法数
        long[] dp = new long[n];
        if (arr[0] == '0') return 0;
        dp[0] = arr[0] == '*' ? 9 : 1;
        if (n == 1) return (int) dp[0];
        if (arr[1] == '*') {
            //单独以 arr[1]作为结尾
            dp[1] = (dp[1] + 9 * dp[0]) % MOD;
            //arr[1]与arr[0]共同组成的两位数作为结尾
            int x = count(arr[0], arr[1]);
            dp[1] += x;
//            if (arr[0] == '1') {
//                dp[1] += 9;
//            } else if (arr[0] == 2) {
//                dp[1] += 6;
//            } else if (arr[0] == '*') {
//                dp[1] += 15;
//            }
        } else if (arr[1] == '0') {
            //必须与之前的做匹配
//            if (arr[0] >= '3' && arr[0] <= '9' || arr[0] == '0') return 0;
//            if (arr[0] == '1' || arr[0] == '2') dp[1] += 1; //继承dp[i-2]
//            if (arr[0] == '*') dp[1] += 2;
            int x = count(arr[0], arr[1]);
            dp[1] += x;
        } else {
            //在【1～9】之间
            //单独以自己作为结尾
            dp[1] += 1 * dp[0];
            //arr[1]与arr[0]共同组成的两位数作为结尾
            int x = count(arr[0], arr[1]);
            //继承dp[i-2]
            dp[1] += x;
        }
        if (dp[1] == 0) return 0;

        for (int i = 2; i < n; i++) {
            int cnt = count(arr[i - 1], arr[i]);
            if (arr[i] == '*') {
                //i自己单独作为结尾
                dp[i] = (dp[i] + 9 * dp[i - 1]) % MOD;
                //i,i-1一起组成结尾
                dp[i] = (dp[i] + cnt * (dp[i - 2])) % MOD;
            } else if (arr[i] == '0') {
                dp[i] = (dp[i] + cnt * (dp[i - 2])) % MOD;
            } else {
                dp[i] += dp[i - 1];
                dp[i] = (dp[i] + cnt * (dp[i - 2])) % MOD;
            }
            if (dp[i] == 0) return 0;
        }
        return (int)dp[n - 1];
    }

    //a b 两者组成一个 ， 有几种可能性
    private int count(char a, char b) {
        if (a == '*' && b == '*') return 15;
        if (a == '*') {
            return b >= '0' && b <= '6' ? 2 : 1;
        }
        if (b == '*') {
            if (a == '0') return 0;
            if (a == '1') return 9;
            if (a == '2') return 6;
            return 0;
        }
        if (a == '0') return 0;
        int num = (a - '0') * 10 + (b - '0');
        return num >= 10 && num <= 26 ? 1 : 0;
    }
}
