package 单调栈;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;

//找到一个数字右边的第二个更大元素，来自第90场周赛


//周赛没写出来  单调栈 + 优先队列 || 两个单调栈
public class _下一个更大元素IV {
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        //小顶栈，如果遇到比栈顶大的值,那么表示栈顶元素找到了他的右边第一个更大元素，将其弹出堆加入优先队列
        var stack = new ArrayDeque<Integer>();
        //小顶堆，堆中的元素都是已经找到右边第一个更大元素，但还没找到第二个更大元素的值，如果遇到比堆顶大的元素，那么改元素就是堆顶元素的右边第二个更大值
        var pq = new PriorityQueue<Integer>((a, b) -> {
            return nums[a] - nums[b];
        });
        for (int i = 0; i < nums.length; i++) {
            while (!pq.isEmpty() && nums[i] > nums[pq.peek()]) res[pq.poll()] = nums[i];
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) pq.add(stack.pop());
            stack.push(i);
        }
        return res;
    }
}
