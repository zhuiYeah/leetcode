package 贪心;

/**
 *
 * 有两个长度相同的字符串 s1 和 s2，且它们其中 只含有 字符 "x" 和 "y"，你需要通过「交换字符」的方式使这两个字符串相同。
 *
 * 每次「交换字符」的时候，你都可以在两个字符串中各选一个字符进行交换。
 *
 * 交换只能发生在两个不同的字符串之间，绝对不能发生在同一个字符串内部。也就是说，我们可以交换 s1[i] 和 s2[j]，但不能交换 s1[i] 和 s1[j]。
 *
 * 最后，请你返回使 s1 和 s2 相同的最小交换次数，如果没有方法能够使得这两个字符串相同，则返回 -1 。
 * */

//o n^2 暴力模拟 + 贪心
public class 交换字符使得字符串相同 {
    public int minimumSwap(String s1, String s2) {
        if (s1.length() != s2.length()) return -1;
        int x = 0, y = 0;
        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();
        for (char c : ss1) {
            if ((c == 'x')) x++;
            else y++;
        }
        for (char c : ss2) {
            if ((c == 'x')) x++;
            else y++;
        }
        if (x % 2 == 1 || y % 2 == 1) return -1;
        int cnt = 0;
        int n = s2.length();
        for (int i = 0; i < n; i++) {
            if (ss1[i] == ss2[i]) continue;
            int j = i + 1;
            for (; j < n; j++) if (ss1[i] == ss1[j] && ss2[i] == ss2[j]) break;

            if (j == n) {//没找到后续交换对象
                ss1[i] = (ss1[i] == 'x') ? 'y' : 'x';
                ss2[i] = (ss2[i] == 'x') ? 'y' : 'x';
                i--;
            } else {//找到后续交换对象
                ss1[i] = ss2[i];
                ss2[j] = ss1[j];
            }
            cnt++;
        }
        return cnt;
    }
}
