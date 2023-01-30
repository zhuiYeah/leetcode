package 链蒸蒸简单;

import java.util.Arrays;

//两个字符串，aaacccbbb和 cba 是 相似字符串，计算相似字符串的对数


//排序 + 枚举
public class 统计相似字符串对的数目 {
    public int similarPairs(String[] words) {
        int n = words.length;
        for (int i = 0; i < n; i++) {
            char[] s = words[i].toCharArray();
            Arrays.sort(s);
            var sb = new StringBuffer(new String(s));
            for (int j = 1; j < sb.length(); j++) {
                if (sb.charAt(j - 1) == sb.charAt(j)) {
                    sb.deleteCharAt(j);
                    j--;
                }
            }
            words[i] = sb.toString();
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (words[i].equals(words[j])) cnt++;
            }
        }
        return cnt;
    }
}
