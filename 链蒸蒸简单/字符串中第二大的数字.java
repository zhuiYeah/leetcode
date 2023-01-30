package 链蒸蒸简单;

public class 字符串中第二大的数字 {
    public int secondHighest(String s) {
        int n = s.length();
        int first = -1;
        int second = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') continue;
            int num = s.charAt(i) - '0';
            if (num == first || num == second) continue;
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second) {
                second = num;
            }
        }
        return second;
    }
}
