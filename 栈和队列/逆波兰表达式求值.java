package 栈和队列;

import java.util.ArrayDeque;

public class 逆波兰表达式求值 {
    public static int evalRPN(String[] tokens) {
        var stack = new ArrayDeque<Integer>();
        for (String token : tokens) {
            int num1 = 0, num2 = 0;
            switch (token) {
                case "*" -> {
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num1 * num2);
                }
                case "/" -> {
                    num2 = stack.pop();
                    num1 = stack.pop();
                    stack.push(num1 / num2);
                }
                case "+" -> {
                    num1 = stack.pop();
                    num2 = stack.pop();
                    stack.push(num1 + num2);
                }
                case "-" -> {
                    num2 = stack.pop();
                    num1 = stack.pop();
                    stack.push(num1 - num2);
                }
                default -> stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args){
        var s = new String[] {"4","13","5","/","+"};
        evalRPN(s);
    }
}
