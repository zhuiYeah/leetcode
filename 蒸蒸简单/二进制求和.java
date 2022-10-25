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


///二进制加法
class dwdwed {
    public String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();
        int add = 0;
        StringBuilder res = new StringBuilder();
        int i = 0;
        while (i < m || i < n) {
            if (i < m) add += a.charAt(m - i - 1) - '0';
            if (i < n) add += b.charAt(n - 1 - i) - '0';
            res.insert(0, add % 2);
            add /= 2;
            i++;
        }
        if (add == 1) res.insert(0, 1);
        return res.toString();
    }
}