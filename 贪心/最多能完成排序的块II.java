package 贪心;

import java.util.ArrayDeque;

public class 最多能完成排序的块II {
    public int maxChunksToSorted(int[] arr) {
        var stack = new ArrayDeque<Integer>();
        for (int i = 0; i < arr.length; i++) {
            var maxOfThisBlock = 0;
            if (!stack.isEmpty() && arr[i] < stack.peek()) {
                maxOfThisBlock = stack.peek();
                while (!stack.isEmpty() && arr[i] < stack.peek()) {
                    stack.pop();
                }
            }
            stack.push(Math.max(maxOfThisBlock, arr[i]));
        }
        return stack.size();
    }
}
