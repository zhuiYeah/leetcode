package 字典树;

import java.util.List;

import 字典树.Trie;


//剑指offer
public class 单词替换 {
    public String replaceWords(List<String> dictionary, String sentence) {
        var tree = new Trie();
        for (String word : dictionary) tree.insert(word);
        var s = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            var prefix = tree.searchTheMinPrefix(s[i]);
            if (!prefix.equals("")) s[i] = prefix;
        }
        var sb = new StringBuilder();
        for (String word : s) {
            sb.append(word);
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
