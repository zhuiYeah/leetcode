package 堆;

import java.util.PriorityQueue;

public class 堆_数据流的第k大数值 {
    class KthLargest {
        //堆默认是小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int K;

        public KthLargest(int k, int[] nums) {
            K = k;
            for (int i = 0; i < nums.length; i++) {
                if (pq.size() == k) {
                    if (nums[i] > pq.peek()) {
                        pq.poll();
                        pq.add(nums[i]);
                    }
                } else {
                    pq.add(nums[i]);
                }
            }
        }

        public int add(int val) {
            if (pq.size() == K) {
                if (val > pq.peek()) {
                    pq.poll();
                    pq.add(val);
                }
            } else {
                pq.add(val);
            }
            return pq.peek();
        }
    }

}
