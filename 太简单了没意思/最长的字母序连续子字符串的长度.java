package 太简单了没意思;

//返回最长的字母连续子串的长度
public class 最长的字母序连续子字符串的长度 {
    public int longestContinuousSubstring(String s) {
        int max = 1;
        int start = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) - s.charAt(i - 1) == 1) {
                max = Math.max(i - start + 1, max);
            } else {
                start = i;
            }
        }
        return max;
    }
}
