package 太简单了没意思;

import java.util.ArrayDeque;

public class 比较含退格的字符串 {
    public boolean backspaceCompare(String s, String t) {
        return xxxx(s).equals(xxxx(t));
    }

    public String xxxx(String s) {
        var stack = new ArrayDeque<Character>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (stack.isEmpty()) continue;
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        var sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var stack = new ArrayDeque<Character>();
        var s = "ab";
        stack.push('a');
        stack.push('b');
        System.out.println(stack.toString());
    }
}
