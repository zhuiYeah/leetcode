package 递归;

public class 找出第N个二进制字符串中的第K位 {
    public char findKthBit(int n, int k) {
        return f(n).charAt(k - 1);
    }

    public String f(int n) {
        if (n == 0) return "0";
        String s = f(n - 1);
        return s + "1" + reverse(s);
    }

    public String reverse(String s) {
        char[] c = s.toCharArray();
        int n = c.length;
        for (int i = 0; i < c.length / 2; i++) {
            var tmp = c[i];
            c[i] = (char) ('1' - c[n - 1 - i] + '0');
            c[n - 1 - i] = (char) ('1' - tmp + '0');
        }
        if (c.length % 2 == 1) {
            c[c.length / 2] = (char) ('1' - c[c.length / 2] + '0');
        }
        return new String(c);
    }
}
