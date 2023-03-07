package 滑动窗口;

public class __替换子串得到平衡字符串 {
    public int balancedString(String S) {
        var s = S.toCharArray();
        int n = s.length / 4;
        int[] cnt = new int['Z'];
        for (var c : s) cnt[c]++;
        int res = Integer.MAX_VALUE;
        if (cnt['Q'] == n && cnt['W'] == n && cnt['E'] == n && cnt['R'] == n) return 0;
        int l = 0;
        //枚举所有的右端点
        for (int r = 0; r < s.length; r++) {
            cnt[s[r]]--;
            //如果能进入该循环，表示[l,r] 这一子串进行变换后能使字符串平衡
            while (cnt['Q'] <= n && cnt['W'] <= n && cnt['E'] <= n && cnt['R'] <= n) {
                res = Math.min(res, r - l + 1);
                //缩小范围
                cnt[s[l]]++;
                l++;
            }
        }
        return res;
    }
}
