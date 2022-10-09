package 栈和队列;

import java.util.ArrayDeque;

public class _括号的分数 {
    public static int scoreOfParentheses(String s) {
        var stack = new ArrayDeque<Integer>();
        stack.push(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(0);
            } else {
                int val = stack.pop();
                int top = stack.pop();
                stack.push(Math.max(2 * val, 1) + top);
            }
        }

        return stack.peek();
    }

    public static void main(String[] args) {
        scoreOfParentheses("(()(()))");
    }
}


class edcsadce {
    public static int scoreOfParentheses(String s) {
        int deep = 0;
        int score = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                deep++;
            } else {
                deep--;
            }
            if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
                score += 1 << deep;
            }
        }
        return score;
    }
}
