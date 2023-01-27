package 贪心;

/**
 * 需要给出一个长为n，总和为k的只包含小写字母的字符串 ，a:1 ... z:26
 * 并且使得这个字符串的字典序最小
 * */

public class 具有给定数值的最小字符串 {
    public String getSmallestString(int n, int k) {
        var sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            var rest = k - (n - i) * 26;
            if (rest <= 1) {
                sb.append('a');
                k -= 1;
            } else {
                sb.append((char) ('a' - 1 + rest));
                k -= rest;
            }
        }
        return sb.toString();
    }
}

class freferw {
    public static void main(String[] args) {
        var s = new 具有给定数值的最小字符串().getSmallestString(5, 73);
        System.out.println(s);
    }
}