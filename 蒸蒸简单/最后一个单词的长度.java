package 蒸蒸简单;

public class 最后一个单词的长度 {
    public int lengthOfLastWord(String s) {
        int start = -1;
        int end = -1;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (start == -1 && s.charAt(i) != ' ') start = i;
            if (start != -1 && s.charAt(i) == ' ') {
                end = i;
                break;
            }
        }
        return start - end;
    }
}
