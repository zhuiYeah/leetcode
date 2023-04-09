package 数学;


/**
 * 给你一个整数 n ，以二进制字符串的形式返回该整数的 负二进制（base -2）表示。
 * <p>
 * 注意，除非字符串就是 "0"，否则返回的字符串中不能含有前导零。
 */
public class __负二进制转换 {
    public String baseNeg2(int n) {
        if (n == 0 || n == 1) return String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int remainder = n & 1;
            sb.append(remainder);
            n -= remainder;
            n /= -2;
        }
        return sb.reverse().toString();
    }
}
