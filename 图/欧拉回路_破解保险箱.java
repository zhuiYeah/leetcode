package 图;

import java.util.HashSet;
import java.util.Set;

/**密码有n位，密码的每一位都在【0～k-1】之间，给出一个最短的字符串，字符串的子串包含了全部的可能的密码**/

/**例如n=2，k=2；那么00110就包含了所有的密码00 01 11 10
 * n = 3 , k= 2;那么 0011101000 包含了全部的结果 000 001 011 111 110 101 010 100
 *
 * **/

public class 欧拉回路_破解保险箱 {
    Set<Integer> seen = new HashSet<Integer>();
    StringBuffer ans = new StringBuffer();
    int highest;
    int k;

    public String crackSafe(int n, int k) {
        highest = (int) Math.pow(10, n - 1);
        this.k = k;
        dfs(0);
        for (int i = 1; i < n; i++) {
            ans.append('0');
        }
        return ans.toString();
    }

    public void dfs(int node) {
        for (int x = 0; x < k; ++x) {
            int nei = node * 10 + x;
            if (!seen.contains(nei)) {
                seen.add(nei);
                dfs(nei % highest);
                ans.append(x);
            }
        }
    }
}
