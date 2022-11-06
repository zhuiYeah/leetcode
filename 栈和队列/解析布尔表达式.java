package 栈和队列;

import java.util.ArrayDeque;
import java.util.Deque;

//栈 + 模拟
//stack1只存三个运算符，stack2只存放 （，t，f
public class 解析布尔表达式 {
    private Deque<Character> stack1;//存放运算符
    private Deque<Character> stack2;

    public boolean parseBoolExpr(String expression) {
        stack1 = new ArrayDeque<Character>();
        stack2 = new ArrayDeque<Character>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == ')') {
                update();
            } else if (c == '(' || c == 't' || c == 'f') {
                stack2.push(c);
            } else if (c == '|' || c == '&' || c == '!') {
                stack1.push(c);
            }
        }
        return stack2.peek() == 't';
    }

    private void update() {
        char c = stack1.pop();
        var x = true;
        if (c == '!') {
            x = stack2.pop() == 'f';
        } else if (c == '&') {
            x = true;
            while (stack2.peek() != '(') {
                if (stack2.pop() == 'f') x = false;
            }
        } else if (c == '|') {
            x = false;
            while (stack2.peek() != '(') {
                if (stack2.pop() == 't') x = true;
            }
        }
        stack2.pop();//弹出 （
        stack2.push(x ? 't' : 'f');
    }
}
