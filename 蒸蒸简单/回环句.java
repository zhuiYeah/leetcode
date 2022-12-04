package 蒸蒸简单;

//判断一个句子是不是回环句
public class 回环句 {
    public boolean isCircularSentence(String sentence) {
        var words = sentence.split(" ");
        int n = words.length;
        if (n == 1) return words[0].charAt(0) == words[0].charAt(words[0].length() - 1);
        var pre = words[0].charAt(words[0].length() - 1);
        for (int i = 1; i < n; i++) {
            if (words[i].charAt(0) != pre) return false;
            pre = words[i].charAt(words[i].length() - 1);
        }
        return words[0].charAt(0) == pre;
    }
}
