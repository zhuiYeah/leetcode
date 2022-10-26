package 堆;

import java.util.PriorityQueue;

public class 堆_数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        var pq = new PriorityQueue<Integer>((a, b) -> {
            return a - b;
        });
        for (int i = 0; i < nums.length; i++) {
            if (pq.size() < k) {
                pq.add(nums[i]);
            } else {
                if (nums[i] > pq.peek()) {
                    pq.poll();
                    pq.add(nums[i]);
                }
            }
        }
        return pq.peek();
    }
}
