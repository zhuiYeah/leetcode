package 字符串;

public class 字符串轮转 {
    public boolean isFlipedString(String s1, String s2) {
        return (s1.length() == s2.length() && (s1 + s1).contains(s2));
    }
}
