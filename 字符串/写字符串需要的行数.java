package 字符串;

public class 写字符串需要的行数 {
    int row = 1;
    int col = 0; //可以从长为col + 1的地方写数字

    public int[] numberOfLines(int[] widths, String s) {
        if (col == 100) {
            row++;
            col = 0;
        }
        for (int i = 0; i < s.length(); i++) {
            int theLen = widths[s.charAt(i) - 'a'];
            if (col + theLen > 100) {
                row++;
                col = theLen;
            } else {
                col += theLen;
            }

        }
        return new int[]{row, col};
    }
}
