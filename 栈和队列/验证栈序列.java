package 栈和队列;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

//简单模拟
//双端队列Deque 比 Stack 要快很多
public class 验证栈序列 {
    static Deque<Integer> stack = new ArrayDeque<>();
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        //Stack<Integer> stack = new Stack<Integer>();

        int ptr = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[ptr]) {
                stack.pop();
                ptr++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1});
    }
}
