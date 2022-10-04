package 栈和队列;

import java.util.ArrayDeque;

public class 最小栈 {

}

//注意 add 和 push的区别
//add用于队列，push用于栈
class MinStack {
    ArrayDeque<Integer> stack;
    ArrayDeque<Integer> stackMin;

    public MinStack() {
        stack = new ArrayDeque<Integer>();
        stackMin = new ArrayDeque<Integer>();
        stackMin.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        stackMin.push(Math.min(stackMin.peek(), val));
    }

    public void pop() {
        stackMin.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stackMin.peek();
    }
}