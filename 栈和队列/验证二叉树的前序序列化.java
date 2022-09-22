package 栈和队列;

import java.util.ArrayDeque;

//7ms 超过 20%
public class 验证二叉树的前序序列化 {
    class Node {
        String val;
        boolean left;
        boolean right;

        public Node(String val, boolean left, boolean right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidSerialization(String preorder) {
        var order = preorder.split(",");
        var stack = new ArrayDeque<Node>();
        int N = order.length;
        int i = 1;
        if (N == 1 && order[0].equals("#")) {
            return true;
        }
        if (order[0].equals("#")) {
            return false;
        }
        stack.push(new Node(order[0], false, false));
        for (i = 1; i < N; i++) {
            if (order[i].equals("#")) {
                if (!stack.isEmpty()) {
                    if (!stack.peek().left && !stack.peek().right) {
                        stack.peek().left = true;
                    } else if (stack.peek().left && !stack.peek().right) {
                        stack.peek().right = true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (!stack.isEmpty()) {
                    if (!stack.peek().left && !stack.peek().right) {
                        stack.peek().left = true;
                    } else if (stack.peek().left && !stack.peek().right) {
                        stack.peek().right = true;
                    } else {
                        return false;
                    }
                    stack.push(new Node(order[i], false, false));
                } else {
                    return false;
                }
            }
            while (!stack.isEmpty() && stack.peek().left && stack.peek().right) {
                stack.pop();
            }
        }
        return i == N && stack.isEmpty();
    }
}
