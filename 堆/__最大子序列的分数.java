package 堆;

import java.util.Arrays;
import java.util.PriorityQueue;

//周赛T3  贪心 + 堆

/**
 * 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，两者长度都是 n ，再给你一个正整数 k 。你必须从 nums1 中选一个长度为 k 的 子序列 对应的下标。
 * <p>
 * 对于选择的下标 i0 ，i1 ，...， ik - 1 ，你的 分数 定义如下：
 * <p>
 * nums1 中下标对应元素求和，乘以 nums2 中下标对应元素的 最小值 。
 * 用公示表示： (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) * min(nums2[i0] , nums2[i1], ... ,nums2[ik - 1]) 。
 * 请你返回 最大 可能的分数。
 */

public class __最大子序列的分数 {
//    public long maxScore(int[] nums1, int[] nums2, int k) {
//        int n = nums1.length;
//        long res = 0;
//        long sum = 0;
//        for (int i = 0; i < k; i++) {
//
//        }
//    }

    //大佬的答案
    public long maxScore(int[] nums1, int[] nums2, int k) {
        Integer[] index = new Integer[nums1.length];
        for (int i = 0; i < index.length; i++)
            index[i] = i;

        Arrays.sort(index, (a, b) -> nums2[b] - nums2[a]);
        long max = 0, sum = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums1.length; i++) {
            sum += nums1[index[i]];
            queue.offer(nums1[index[i]]);
            if (queue.size() > k) {
                sum -= queue.poll();
            }
            max = Math.max(max, queue.size() < k ? 0 : sum * nums2[index[i]]);
        }
        return max;
    }
}

/**
 * 本题的突破点之一：如何快速确定k个子序列中的最小值 ？
 * 答：当然是给他排序，然后从大到小添加，新添加的值肯定是最小的
 */

class dewdew {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long max = 0, sum = 0;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> nums2[b] - nums2[a]);
        var pq = new PriorityQueue<Integer>((a, b) -> a - b);
        for (int i = 0; i < n; i++) {
            int index = idx[i]; //新添加的 nums2[index]一定是目前的子序列中最小的
            sum += nums1[index];
            pq.add(nums1[index]);
            if (pq.size() > k) sum -= pq.poll();
            if (pq.size() == k) max = Math.max(max, sum * nums2[index]);
        }
        return max;
    }
}

