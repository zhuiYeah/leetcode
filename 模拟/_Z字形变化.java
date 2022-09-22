package 模拟;

import java.util.ArrayList;

public class _Z字形变化 {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        ArrayList<StringBuilder> list = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder(""));
        }
        int i = 0, flag = -1;//究极精髓
        for (char c : s.toCharArray()) {
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            list.get(i).append(c);
            i += flag;
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < list.size(); j++) {
            sb.append(list.get(j));
        }
        return sb.toString();
    }
}
