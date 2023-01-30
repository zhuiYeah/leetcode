package 链蒸蒸简单;

public class 检查两个字符串数组是否相等 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        var sb1 = new StringBuilder();
        var sb2 = new StringBuilder();
        for (int i = 0; i < word1.length; i++) sb1.append(word1[i]);
        for (int i = 0; i < word2.length; i++) sb2.append(word2[i]);
        return sb1.toString().equals(sb2.toString());
    }
}
