package 数学;

public class _连续整数求和 {
    public int consecutiveNumbersSum(int n) {
        int res = 0;
        for (int i = 1; n > 0; n -= i++) {
            if (n % i == 0) {
                res++;
            }
        }
        return res;
    }
}
