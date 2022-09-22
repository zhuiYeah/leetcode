package 字符串;

import java.util.ArrayList;

//细节繁琐
public class 重新排列单词间的空格 {
    public String reorderSpaces(String text) {
        ArrayList<String> word = new ArrayList<String>();
        int nullNum = 0;
        int start = 0, end = 1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ' && i == 0 || text.charAt(i) != ' ' && text.charAt(i - 1) == ' ') {
                start = i;
            }
            if (text.charAt(i) != ' ' && i == text.length() - 1) {
                end = text.length();
                word.add(text.substring(start, end));
            }
            if (i > 0 && text.charAt(i) == ' ' && text.charAt(i - 1) != ' ') {
                end = i;
                word.add(text.substring(start, end));
            }

            if (text.charAt(i) == ' ') {
                nullNum++;
            }
        }
        if (word.size() == 1) {
            return word.get(0) + " ".repeat(nullNum);
        }
        int xx = nullNum / (word.size() - 1);
        int rest = nullNum % (word.size() - 1);
        StringBuilder s = new StringBuilder();
        s.append(" ".repeat(xx));

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < word.size() - 1; i++) {
            res.append(word.get(i));
            res.append(s);
        }
        res.append(word.get(word.size() - 1));
        res.append(" ".repeat(rest));
        return res.toString();
    }
}
