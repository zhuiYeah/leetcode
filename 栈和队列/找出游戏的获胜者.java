package 栈和队列;

import java.util.ArrayDeque;

public class 找出游戏的获胜者 {
    public int findTheWinner(int n, int k) {
        var queue = new ArrayDeque<Integer>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        while (queue.size() != 1) {
            for (int i = 1; i <= k; i++) {
                int x = queue.poll();
                if (i != k) queue.add(x);
            }
        }
        return queue.peek();
    }
}
