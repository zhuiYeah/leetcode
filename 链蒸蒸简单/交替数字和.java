package 链蒸蒸简单;

public class 交替数字和 {
    public int alternateDigitSum(int n) {
        String num = String.valueOf(n);
        char[] digits = num.toCharArray();
        int m = digits.length;
        int res = 0;
        int flag = 1;

        for (int i = 0; i < m; i++) {
            res += flag * (digits[i] - '0');
            flag *= -1;
        }
        return res;
    }
}
