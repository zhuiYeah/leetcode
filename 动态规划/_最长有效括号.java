package 动态规划;

import java.util.ArrayDeque;
import java.util.ArrayList;


//106/231
// （（）（）） 测试用例让人醒悟
//我的思路是 dp[i][j] 最长回文子串  区间dp，但这一题不是区间dp
public class _最长有效括号 {
    public int longestValidParentheses(String s) {
        int n = s.length();
        var dp = new boolean[n][n];
        int max = 0;
        var line = new ArrayList<int[]>();
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == '(' && s.charAt(j) == ')') {
                    if (j - i == 1 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
                if (dp[i][j]) {
                    line.add(new int[]{i, j});
                }

            }
        }
        line.sort((a, b) -> {
            return a[0] - b[0];
        });
        int start = -1, end = -2;
        for (int[] ints : line) {
            int a = ints[0], b = ints[1];
            if (a > end + 1) {
                max = Math.max(max, end - start + 1);
                start = a;
                end = b;
            } else if (b > end) {
                end = b;
            }
        }
        max = Math.max(max, end - start + 1);

        return max;
    }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
//用栈模拟一遍，将所有无法匹配的括号的位置全部置1
//例如: "()(()"的mark为[0, 0, 1, 0, 0]
//再例如: ")()((())"的mark为[1, 0, 0, 1, 0, 0, 0, 0]
//经过这样的处理后, 此题就变成了寻找最长的连续的0的长度
class dwfdwe {
    class XX {
        int index;
        char c;

        public XX(int index, char c) {
            this.index = index;
            this.c = c;
        }
    }

    public int longestValidParentheses(String s) {
        int[] nums = new int[s.length()];
        var stack = new ArrayDeque<XX>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(new XX(i, c));
            } else if (s.charAt(i) == ')' && stack.peek().c == '(') {
                stack.pop();
            } else {
                stack.push(new XX(i, c));
            }
        }
        while (!stack.isEmpty()) {
            nums[stack.pop().index] = 1;
        }
        //找数组中0的最大连续长度
        int max = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                max = Math.max(max, i - start + 1);
            } else {
                start = i + 1;
            }
        }
        return max;
    }
}


//////////////////////////////////////////////////////////////////////////////////////////////////////////////
class swdw {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] pos = new int[n];
        var stack = new ArrayDeque<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }
        while (!stack.isEmpty()) {
            pos[stack.pop()] = 1;
        }
        //接下来找到连续的0的最大长度
        int max = 0;
        int start = 0;
        for (int i = 0; i < pos.length; i++) {
            if (pos[i] == 0) {
                max = Math.max(max, i - start + 1);
            } else {
                start = i + 1;
            }
        }
        return max;
    }
}
