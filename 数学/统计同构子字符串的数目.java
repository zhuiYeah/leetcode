package 数学;

import java.util.ArrayList;

//给你一个字符串 s ，返回 s 中 同构子字符串 的数目
//同构字符串 的定义为：如果一个字符串中的所有字符都相同，那么该字符串就是同构字符串。

/**
 * 输入：s = "abbcccaa"
 * 输出：13
 * 解释：同构子字符串如下所列：
 * "a"   出现 3 次。
 * "aa"  出现 1 次。
 * "b"   出现 2 次。
 * "bb"  出现 1 次。
 * "c"   出现 3 次。
 * "cc"  出现 2 次。
 * "ccc" 出现 1 次。
 **/
public class 统计同构子字符串的数目 {
    final int MOD = (int) (1e9 + 7);

    public int countHomogenous(String s) {
        var list = new ArrayList<Integer>();
        for (int i = 1; i <= s.length(); i++) {
            var x = i;
            while (x < s.length() && s.charAt(x) == s.charAt(x - 1)) x++;
            list.add(x - i + 1);
            i = x;
        }
        long res = 0;
        for (int i = 0; i < list.size(); i++) {
            var x = list.get(i);
            res = (res + (long) (x + 1) * x / 2) % MOD;
        }

        return (int) res;
    }


}
