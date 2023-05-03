package 栈和队列;

import java.util.ArrayDeque;
import java.util.Deque;

public class 检查替换后的词是否有效 {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'c') {
                if (stack.size() >= 2) {
                    char b = stack.pollLast();
                    if (b == 'b' && stack.peekLast() == 'a') stack.pollLast();
                    else return false;
                } else return false;
            } else {
                stack.add(c);
            }
        }
        return stack.isEmpty();
    }
}


class few{
    public static void main(String[] args){
        new 检查替换后的词是否有效().isValid("abcabcababcc");
    }
}
