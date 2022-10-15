package 蒸蒸简单;

public class 二进制求和 {
    public String addBinary(String a, String b) {
        int m = a.length(), n = b.length();
        int x = Math.max(m, n);
        int carry = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < x; i++) {
            if (i < m) carry += a.charAt(m - 1 - i) - '0';
            if (i < n) carry += b.charAt(n - i - 1) - '0';
            char xx = (char) (carry % 2 + '0');
            res.insert(0, xx);
            carry /= 2;
        }
        if (carry == 1) res.insert(0, '1');
        return res.toString();
    }
}
