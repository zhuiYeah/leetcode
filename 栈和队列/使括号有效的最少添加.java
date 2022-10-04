package 栈和队列;

import java.util.ArrayDeque;

public class 使括号有效的最少添加 {
    public int minAddToMakeValid(String s) {
        var stack = new ArrayDeque<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(')');
                }
            }
        }
        return stack.size();
    }
}
