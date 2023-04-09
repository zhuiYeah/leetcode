package 哈希表;

import java.util.HashMap;

//统计两个字符串中只差一个字符的子串对的总数

//57/63    TLE
public class 统计只差一个字符的子串数目 {
    public int countSubstrings(String s, String t) {
        HashMap<String, Integer> cnt = new HashMap<>();
        int n = s.length();
        for (int l = 0; l < n; l++) {
            for (int r = l + 1; r <= n; r++) {
                String str = s.substring(l, r);
                //对str字符串操作一位存入cnt中
                char[] arr = str.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char c = arr[i];
                    //第i个位置改成x并计入cnt中
                    for (char x = 'a'; x <= 'z'; x++) {
                        if (x == c) continue;
                        arr[i] = x;
                        String newStr = new String(arr);
                        cnt.put(newStr, cnt.getOrDefault(newStr, 0) + 1);
                    }
                    arr[i] = c;
                }
            }
        }
        int m = t.length();
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j <= m; j++) {
                String str = t.substring(i, j);
                res += cnt.getOrDefault(str, 0);
            }
        }
        return res;
    }
}

class dew {
    public static void main(String[] args) {
        String s = "cavfaevrf";
        char[] arr = s.toCharArray();
        arr[2] = '#';
        String ew = new String(arr);
        System.out.println("ew = " + ew);

        int i = new dre().countSubstrings("a", "b");
    }
}


class dre {
    public int countSubstrings(String s, String t) {
        int sn = s.length(), tn = t.length();
        int MAXLEN = Math.min(sn, tn);
        int cnt = 0;
        for (int len = 1; len <= MAXLEN; len++) {
            for (int i = 0; i < sn - len + 1; i++) {
                String ss = s.substring(i, len + i);
                for (int j = 0; j < tn - len + 1; j++) {
                    String tt = t.substring(j, len + j);
                    if (ss.equals(tt)) continue;
                    if (yesOk(ss, tt)) cnt++;
                }
            }
        }
        return cnt;
    }

    private boolean yesOk(String s, String t) {
        int n = s.length();
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (ss[i] != tt[i]) cnt++;
            if (cnt >= 2) return false;
        }
        return cnt == 1;
    }
}