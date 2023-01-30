package 链蒸蒸简单;

public class 生成交替二进制字符串的最少操作数 {
    public int minOperations(String s) {
        int n = s.length();
        int x = 0;
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) - '0' != x) cnt1++;
            x = 1 - x;
        }
        x = 1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) - '0' != x) cnt2++;
            x = 1 - x;
        }
        return Math.min(cnt1, cnt2);
    }
}
