package 栈和队列;

import java.util.ArrayList;
import java.util.Stack;

public class 删除最外层的括号 {
    ArrayList<Character> stack = new ArrayList<Character>();
    int leftBrackets = 0;
    int rightBrackets = 0;

    public String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftBrackets++;
            } else {
                rightBrackets++;
            }
            stack.add(s.charAt(i));

            if (leftBrackets == rightBrackets) {
                for (int j = 1; j < stack.size() - 1; j++) {
                    res.append(stack.get(j));
                }
                stack.clear();
                leftBrackets = 0;
                rightBrackets = 0;
            }
        }
        return res.toString();
    }
}
