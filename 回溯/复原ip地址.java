package 回溯;

import java.util.ArrayList;
import java.util.List;

//剑指offer
public class 复原ip地址 {
    int n;
    String S;
    List<String> res = new ArrayList<>();
    List<String> path = new ArrayList<>();


    public List<String> restoreIpAddresses(String s) {
        n = s.length();
        S = s;
        if (n > 12 || n < 4) return res;
        backtracking(1, 0);
        return res;
    }

    private void backtracking(int cur, int pre) {
        //边界，已经切割三块了，剩下来的必须全部切割
        if (path.size() == 3) {
            if (isValidIp(S.substring(cur - 1))) {
                String ip = path.get(0) + "." + path.get(1) + '.' + path.get(2) + '.' + S.substring(cur - 1);
                res.add(ip);
            }
            return;
        }
        //递归终止
        if (cur == n) return;
        //如果这里（左）能切割的话，两个选择 ， 切割或不切割
        if (isValidIp(S.substring(pre, cur))) {
            path.add(S.substring(pre, cur));
            backtracking(cur + 1, cur);
            path.remove(path.size() - 1);
            backtracking(cur + 1, pre);
        }
    }

    private boolean isValidIp(String ip) {
        if (ip.length() > 3 || ip.length() == 0) return false;
        if (ip.length() != 1 && ip.charAt(0) == '0') return false;
        if (ip.length() == 1) return true;
        int ipx = Integer.parseInt(ip);
        return ipx >= 0 && ipx <= 255;
    }
}
