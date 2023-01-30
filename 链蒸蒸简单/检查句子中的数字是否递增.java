package 链蒸蒸简单;

import java.util.ArrayList;

public class 检查句子中的数字是否递增 {
    public boolean areNumbersAscending(String s) {
        var ss = s.split(" ");
        var list = new ArrayList<Integer>();
        for (String x : ss) {
            if (isNum(x)) list.add(Integer.parseInt(x));
        }
        for (int i = 1; i < list.size(); i++)
            if (list.get(i) <= list.get(i - 1)) return false;

        return true;
    }

    private boolean isNum(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') continue;
            return false;
        }
        return true;
    }
}
