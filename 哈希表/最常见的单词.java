package 哈希表;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

import static java.lang.Character.isLetter;

public class 最常见的单词 {
    HashMap<String, Integer> fre = new HashMap<>();//记录单词出现的次数
    HashSet<String> ban = new HashSet<>(); //记录禁用表里面的单词
    int start = 0;
    int end;
    int maxFre = 0;

    public String mostCommonWord(String paragraph, String[] banned) {
        ban.addAll(Arrays.asList(banned));//将字符串数组转化为list，将list全部写入哈希集合
        ban.add(""); //否则fre中会出现  null ： int 映射
        ////////////////////////////////////////////////////////////////paragraph = paragraph.trim(); 这个可以省略
        paragraph = paragraph.toLowerCase();
        paragraph += " "; //否则会忽略掉最后一个单词
        for (int i = 0; i < paragraph.length(); i++) {
            if (!isLetter(paragraph.charAt(i))) {
                end = i;
                if (!ban.contains(paragraph.substring(start, end))) {
                    int x = fre.getOrDefault(paragraph.substring(start, end), 0);
                    fre.put(paragraph.substring(start, end), x + 1);
                    maxFre = Math.max(maxFre, x + 1);
                }
                start = i + 1;
            }
        }
        //遍历hashmap
        for (HashMap.Entry<String, Integer> entry : fre.entrySet()) {
            if (entry.getValue() == maxFre) {
                return entry.getKey();
            }
        }
        return null;
    }
}
