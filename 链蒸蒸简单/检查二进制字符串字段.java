package 链蒸蒸简单;

public class 检查二进制字符串字段 {
    public boolean checkOnesSegment(String s) {
        boolean one = false;
        for (int i = 0; i < s.length(); i++) {
            if (!one && s.charAt(i) == '1') {
                one = true;
            }
            if (i > 0 && one && s.charAt(i) == '1' && s.charAt(i - 1) == '0') return false;
        }
        return true;
    }
}
