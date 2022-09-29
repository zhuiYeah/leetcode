package 字符串;

//s1 旋转后 变为 s2
//那么 s1+s1 一定包含 s2
public class 字符串轮转 {
    public boolean isFlipedString(String s1, String s2) {
        return (s1.length() == s2.length() && (s1 + s1).contains(s2));
    }
}
