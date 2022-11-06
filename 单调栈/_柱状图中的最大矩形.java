package 单调栈;

import java.util.ArrayDeque;
import java.util.ArrayList;

//找到每根柱子左边第一个比他矮（大顶栈）的柱子和右边第一个比他矮的柱子，就能得到这个高度的柱子能维护的最大宽度。
public class _柱状图中的最大矩形 {
    public int largestRectangleArea(int[] heights) {
        //大顶栈，计算栈中每个高度能出现的最大长度；大顶栈天然的记录了某一个元素 ，前面的第一个更小元素（栈中自己的前面），后面的第一个更小元素。
        var stack = new ArrayDeque<Integer>();
        var height = new ArrayList<Integer>();
        for (int j : heights) height.add(j);
        height.add(0);
        height.add(0, 0);
        int res = height.get(1);
        for (int i = 0; i < height.size(); i++) {
            //如果满足该while循环的条件，表明栈顶元素找到了右边第一个更大元素，搞他
            while (!stack.isEmpty() && height.get(i) < height.get(stack.peek())) {
                //记录栈顶元素的高并弹出
                int h = height.get(stack.pop());
                //此时栈顶的元素 就是刚刚弹出元素的 左边第一个更小元素，一左一右夹成了宽
                int w = i - stack.peek() - 1;
                res = Math.max(res, w * h);
            }
            stack.push(i);
        }
        return res;
    }
}
