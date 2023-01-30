package 链蒸蒸简单;

public class 统计一致字符串的数目 {
    public int countConsistentStrings(String allowed, String[] words) {
        var tar = new boolean[26];
        for (int i = 0; i < allowed.length(); i++) tar[allowed.charAt(i) - 'a'] = true;
        int count = 0;
        for (String word : words) {
            int i = 0;
            for (i = 0; i < word.length(); i++) {
                if (!tar[word.charAt(i) - 'a']) break;
            }
            if (i == word.length()) count++;
        }
        return count;
    }
}
