package 堆;

import java.util.Arrays;
import java.util.PriorityQueue;

//O（n*log k）
public class 堆_找到和最大的长度为k的子序列 {
    public static int[] maxSubsequence(int[] nums, int k) {
        //堆存放元素下标，小顶堆，堆顶是堆中最小的（第k小的）元素 的 下标
        var pq = new PriorityQueue<Integer>((a, b) -> {
            return nums[a] - nums[b];
        });
        for (int i = 0; i < nums.length; i++) {
            if (pq.size() < k) {
                pq.add(i);
            } else {
                //这个错误排查了好久，之前写成了 nums[i] > pq.peek()
                if (nums[i] > nums[pq.peek()]) {
                    pq.poll();
                    pq.add(i);
                }
            }
        }
        int[] subsequence = new int[k];
        int ptr = 0;
        while (!pq.isEmpty()) {
            subsequence[ptr] = pq.poll();
            ptr++;
        }
        Arrays.sort(subsequence);
        for (int i = 0; i < subsequence.length; i++) {
            int index = subsequence[i];
            subsequence[i] = nums[index];
        }
        return subsequence;
    }

    public static void main(String[] args) {
        maxSubsequence(new int[]{63, -74, 61, -17, -55, -59, -10, 2, -60, -65}, 9);
    }
}
