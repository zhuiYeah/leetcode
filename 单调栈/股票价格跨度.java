package 单调栈;

import java.util.ArrayDeque;
import java.util.Deque;

//到今天为止，包含今天，比今天股票价格低（或者等于）的连续天数有多少天
public class 股票价格跨度 {
}

class X {
    int val;
    int quan;

    public X(int val, int quan) {
        this.val = val;
        this.quan = quan;
    }
}

class StockSpanner {
    Deque<X> stack;

    public StockSpanner() {
        stack = new ArrayDeque<X>();
    }

    public int next(int price) {
        int quan = 1;
        while (!stack.isEmpty() && price >= stack.peek().val) quan += stack.pop().quan;
        stack.push(new X(price, quan));
        return quan;
    }
}