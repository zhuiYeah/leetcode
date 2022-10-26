package 单调队列;

import java.util.ArrayDeque;
import java.util.Deque;

public class 队列的最大值 {

}

//单调递减的队列获得最大值
class MaxQueue {
    Deque<Integer> queue;
    //q队列的头部会存放最大元素  以及该元素的权
    Deque<int[]> q;

    public MaxQueue() {
        queue = new ArrayDeque<>();
        q = new ArrayDeque<>();
    }

    public int max_value() {
        if (q.isEmpty()) return -1;
        return q.peekFirst()[0];
    }

    public void push_back(int value) {
        queue.add(value);
        int quan = 1;
        //一定要谨慎操作双头队列的首尾
        while (!q.isEmpty() && value >= q.peekLast()[0]) quan += q.pollLast()[1];
        q.add(new int[]{value, quan});
    }

    public int pop_front() {
        if (queue.isEmpty()) return -1;
        assert q.peekFirst() != null;
        if (q.peekFirst()[1] == 1) {
            q.pollFirst();
        } else {
            q.peekFirst()[1]--;
        }
        return queue.pollFirst();
    }
}
