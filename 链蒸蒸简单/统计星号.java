package 链蒸蒸简单;

public class 统计星号 {
    public int countAsterisks(String s) {
        int out = 1, cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            if (c == '|') {
                out = 1 - out;
            } else {
                if (c == '*' && out == 1) cnt++;
            }
        }
        return cnt;
    }
}
