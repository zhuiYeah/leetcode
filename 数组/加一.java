package 数组;

public class 加一 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int add = 1;
        for (int i = n - 1; i >= 0; i--) {
            int v = digits[i] + add;
            if (v != 10) {
                digits[i] = v;
                add = 0;
                break;
            }
            digits[i] = 0;
        }
        if (add != 0) {
            var res = new int[n + 1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}
