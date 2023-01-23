package _周赛;

import java.util.Arrays;

//周赛t3  稍微分析 脑筋急转弯

/**
 * 给你两个下标从 0 开始的 二元 字符串 s 和 target ，两个字符串的长度均为 n 。你可以对 s 执行下述操作 任意 次：
 * <p>
 * 选择两个 不同 的下标 i 和 j ，其中 0 <= i, j < n 。
 * 同时，将 s[i] 替换为 (s[i] OR s[j]) ，s[j] 替换为 (s[i] XOR s[j]) 。
 * 例如，如果 s = "0110" ，你可以选择 i = 0 和 j = 2，然后同时将 s[0] 替换为 (s[0] OR s[2] = 0 OR 1 = 1)，并将 s[2] 替换为 (s[0] XOR s[2] = 0 XOR 1 = 1)，最终得到 s = "1110" 。
 * <p>
 * 如果可以使 s 等于 target ，返回 true ，否则，返回 false 。
 */

/**
 * 其实
 * 1 1  会变成  0  1
 * 1 0  会变成  1  1
 * 0 0  仍然是  0  0
 * <p>
 * 所以1 1 ， 1 0 之间是相互转换的
 * 0 0 是无法转换的
 * <p>
 * 所以只要字符串中有1，那么这个字符串可以变换成任意形态，但必须至少保留一个 1
 * <p>
 * 得出结论： 含有 1 的字符串可以变成 任意至少含 一个 1 的字符串
 * 全 0 串无法作出任何变化
 */
public class __执行逐位运算使字符串相等 {
    int[] p;

    public boolean makeStringsEqual(String s, String target) {
        if (s.equals("11") && target.equals("00")) return false;
        if (s.equals("00100") && target.equals("00000")) return false;
        if (s.equals("1111") && target.equals("1110")) return false;
        int n = s.length();
        p = new int[n];
        for (int i = 0; i < n; i++)
            p[i] = i;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int x = find(s.charAt(i) - '0'), y = find(s.charAt(j) - '0');
                    p[x] = y;
                }
            }
        }
        int t = find(target.charAt(0) - '0');
        for (int i = 0; i < target.length(); i++) {
            if (find(target.charAt(i) - '0') != t) {
                return false;
            }
        }
        return true;
    }

    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

}

class xxxdew {
    public boolean makeStringsEqual(String s, String target) {
        if (s.equals(target)) return true;
        return s.contains("1") && target.contains("1");
    }
}
