package 单调栈;

import java.util.ArrayDeque;
import java.util.Deque;

//利用大顶栈记录出现的第一个更小元素
public class 商品折扣后的最终价格 {
    Deque<Integer> stack = new ArrayDeque<Integer>();

    public int[] finalPrices(int[] prices) {
        int[] res = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int index = stack.pop();
                res[index] = prices[index] - prices[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            res[index] = prices[index];
        }
        return res;
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////
//直接克隆数组
class 商品折扣后的最终价格d {
    Deque<Integer> stack = new ArrayDeque<Integer>();

    public int[] finalPrices(int[] prices) {
        int[] res = prices.clone();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int index = stack.pop();
                res[index] = prices[index] - prices[i];
            }
            stack.push(i);
        }
        return res;
    }
}