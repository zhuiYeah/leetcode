package 单调栈;

import java.util.ArrayDeque;

/**
 * 找到一个最长的和大于0的子数组
 * 返回他的长度
 */

/**
 * https://leetcode.cn/problems/longest-well-performing-interval/solutions/2110211/liang-chong-zuo-fa-liang-zhang-tu-miao-d-hysl/
 * 对于s[i],s[j],s[k], i < j < k；
 * 如果 s[j] >= s[i], j不可能作为左端点（因为j作为左端点，那么i一定可以作为左端点）
 * 所以左端点的一定是一段严格单调减少的点
 *
 * 列出所有的左端点（下标递增），从右遍历所有的点i，当prefix[i] - stack.peek()>0时，可能的最长数组已经构成
 */
public class ___表现良好的最长时间段 {
    public int longestWPI(int[] hours) {
        int n = hours.length, res = 0;
        var pre = new int[n + 1];

        var stack = new ArrayDeque<Integer>();
        stack.push(0);
        //维护一个单调递减栈，栈中列出所有可能的左端点
        for (int i = 1; i <= n; i++) {
            pre[i] = (hours[i - 1] > 8 ? 1 : -1) + pre[i - 1];
            if (pre[i] < pre[stack.peek()]) stack.push(i);
        }
        //从右枚举所有的点作为右端点，越右越好
        for (int i = n; i > 0; i--) {
            while (!stack.isEmpty() && pre[i] > pre[stack.peek()])
                res = Math.max(res, i - stack.pop());
        }
        return res;
    }
}
