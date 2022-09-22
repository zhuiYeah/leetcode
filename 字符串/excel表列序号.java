package 字符串;

public class excel表列序号 {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        int bit = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            res += (columnTitle.charAt(i) - 'A' + 1) * bit;
            bit *= 26;
        }
        return res;
    }
}
