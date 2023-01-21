package 蒸蒸简单;
/**如果两个句子 sentence1 和 sentence2 ，可以通过往其中一个句子插入一个任意的句子（可以是空句子）而得到另一个句子，
 * 那么我们称这两个句子是 相似的 。比方说，sentence1 = "Hello my name is Jane" 且 sentence2 = "Hello Jane" ，我们可以往 sentence2 中 "Hello" 和 "Jane" 之间插入 "my name is" 得到 sentence1 。

 给你两个句子 sentence1 和 sentence2 ，如果 sentence1 和 sentence2 是相似的，请你返回 true ，否则返回 false 。*/

//讨论全部情况
public class 句子相似性III {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.equals(sentence2)) return true;
        String[] s1 = sentence1.split(" "), s2 = sentence2.split(" ");
        String[] longWords, shortWords;
        if (s1.length == s2.length) {
            return false;
        } else if (s1.length > s2.length) {
            longWords = s1;
            shortWords = s2;
        } else {
            longWords = s2;
            shortWords = s1;
        }
        //是前缀吗
        if (IsS1StartWithS2(longWords, shortWords)) return true;
        //是后缀吗
        if (IsS1EndWithS2(longWords, shortWords)) return true;
        //两边包夹？
        int l = 0, r = shortWords.length - 1;
        while (shortWords[l].equals(longWords[l])) l++;
        while (shortWords[r].equals(longWords[longWords.length - shortWords.length + r])) r--;
        return l > r ;
    }

    private boolean IsS1StartWithS2(String[] s1, String[] s2) {
        for (int i = 0; i < s2.length; i++) {
            if (!s1[i].equals(s2[i])) return false;
        }
        return true;
    }

    private boolean IsS1EndWithS2(String[] s1, String[] s2) {
        for (int i = 0; i < s2.length; i++) {
            if (!s1[s1.length - 1 - i].equals(s2[s2.length - 1 - i])) return false;
        }
        return true;
    }
}
