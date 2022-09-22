package 字符串;

public class 检查单词是否为句中其他单词的前缀 {
    int index = 0;
    int start = 0;
    int end;

    public int isPrefixOfWord(String sentence, String searchWord) {
        sentence += " ";
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == ' ') {
                index++;
                end = i;
                String sub = sentence.substring(start, end);
                if (sub.startsWith(searchWord)) {
                    return index;
                }
                start = i + 1;
            }
        }
        return -1;
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
}
