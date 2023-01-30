package 链蒸蒸简单;


public class 兼具大小写的最好英文字母 {
    public String greatestLetter(String s) {
        boolean[][] alphabet = new boolean[26][2];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z')
                alphabet[c - 'A'][0] = true;
            else
                alphabet[c - 'a'][1] = true;
        }
        for (int i = 25; i >= 0; i--)
            if (alphabet[i][0] && alphabet[i][1]) return String.valueOf((char) ('A' + i));
        return "";
    }
}
