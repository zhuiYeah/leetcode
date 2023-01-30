package 链蒸蒸简单;

//word字符串在sequence中的最大重复次数

//纯暴
public class 最大重复子字符串 {

    public int maxRepeating(String sequence, String word) {
        int m = sequence.length(), n = word.length();
        int res = m / n;
        while (res > 0) {
            String s = word.repeat(res);
            int len = s.length();
            for (int i = 0; i < m - len + 1; i++) {
                if (sequence.substring(i, i + len).equals(s)) return res;
            }
            res--;
        }
        return 0;
    }
}
