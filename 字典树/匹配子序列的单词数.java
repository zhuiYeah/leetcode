package 字典树;

import java.util.ArrayList;



//二分查找 过  ，如果判断子序列改成动态规划的那种二维判断子序列的方法，则超时
class ded {
    private String S;
    //g[i]会记录s中的出现的 i 字符的全部下标 ，且递增
    ArrayList[] g = new ArrayList[26];

    public int numMatchingSubseq(String s, String[] words) {
        S = s;
        int cnt = 0;

        for (int i = 0; i < g.length; i++) g[i] = new ArrayList<Integer>();
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            g[index].add(i);
        }

        for (String word : words) if (isSubSeq(word)) cnt++;

        return cnt;

    }

    private boolean isSubSeq(String sub) {
        int n = sub.length();
        int left = 0; //当前可以选择S从left开始的所有下标
        for (int i = 0; i < n; i++) {
            int index = sub.charAt(i) - 'a';
            int l = 0, r = g[index].size() - 1;
            int xx = -1; //找到的大于等于left的最小下标
            while (l <= r) {
                int mid = l + (r - l) / 2;
                int idx = (int) g[index].get(mid);
                if (idx >= left) {
                    xx = idx;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            if (xx == -1) return false;
            else left = xx + 1;
        }

        return true;
    }
}


//纯暴力 超时
public class 匹配子序列的单词数 {
    private String S;

    public int numMatchingSubseq(String s, String[] words) {
        S = s;
        int cnt = 0;
        for (String word : words) {
            if (isSubSeq(word)) cnt++;
        }
        return cnt;

    }

    private boolean isSubSeq(String sub) {
        int n = sub.length();
        int ptr = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == sub.charAt(ptr)) ptr++;
            if (ptr == n) return true;
        }
        return false;
    }
}


