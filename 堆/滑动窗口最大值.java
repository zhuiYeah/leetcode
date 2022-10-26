package 堆;

//维护size为k的滑动窗口的最大值。


import java.util.PriorityQueue;


//数组长度n最大为10^5,k最大为n，因此暴力的话时间复杂度O(n k) 超时。

//一次遍历nums ,利用大顶堆时刻维护出现的最大值以及它的下标。到nums[i]时，如果堆顶最大值的下标>=i-k+1,堆顶元素即为滑动窗口最大值，否则弹出堆顶
//时间复杂度 n*logn;
public class 滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        var res = new int[n - k + 1];
        var pq = new PriorityQueue<int[]>((a, b) -> {
            return a[0] == b[0] ? b[1] - a[1] : b[0] - a[0];
        });
        for (int i = 0; i < k; i++) {
            pq.add(new int[]{nums[i], i});
        }
        assert pq.peek() != null;
        res[0] = pq.peek()[0];
        for (int i = k; i < n; i++) {
            pq.add(new int[]{nums[i], i});
            while (pq.peek()[1] < i - k + 1) pq.poll();
            res[i - k + 1] = pq.peek()[0];
        }
        return res;
    }
}
