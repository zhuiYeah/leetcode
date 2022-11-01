package 模拟;

public class 神奇字符串 {
    public int magicalString(int n) {
        StringBuilder s = new StringBuilder("122112");
        int ptr = 4;
        char cur = 1 + '0';
        while (s.length() < n) {
            if (s.charAt(ptr) == '1') {
                s.append(cur);
            } else {
                s.append(cur);
                s.append(cur);
            }
            ptr++;
            cur = (char) (3 + '0' + '0' - cur);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') count++;
        }
        return count;
    }
}
