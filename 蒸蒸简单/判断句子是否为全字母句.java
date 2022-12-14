package 蒸蒸简单;

import java.util.HashSet;

public class 判断句子是否为全字母句 {
    public boolean checkIfPangram(String sentence) {
        var set = new HashSet<Character>();
        for (int i = 0; i < sentence.length(); i++) set.add(sentence.charAt(i));
        return set.size()==26;
    }
}
