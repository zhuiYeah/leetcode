package 排序;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//这是双指针法，是错误的，未考虑所有的排列
public class _查找和最小的k对数字_堆_优先队列 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int ptr1 = 0, ptr2 = 0;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> x = new ArrayList<Integer>();
        x.add(nums1[ptr1]);
        x.add(nums2[ptr2]);
        result.add(x);
        while (true) {
            if (result.size() == k) {
                break;
            }
            if (ptr1 == nums1.length - 1 && ptr2 == nums2.length - 1) {
                break;
            }
            if (ptr1 == nums1.length - 1) {
                ptr2++;
                List<Integer> xx = new ArrayList<Integer>();
                xx.add(nums1[ptr1]);
                xx.add(nums2[ptr2]);
                result.add(xx);
                continue;
            }
            if (ptr2 == nums2.length - 1) {
                ptr1++;
                List<Integer> xx = new ArrayList<Integer>();
                xx.add(nums1[ptr1]);
                xx.add(nums2[ptr2]);
                result.add(xx);
                continue;
            }
            int num1 = nums1[ptr1 + 1] + nums2[ptr2];
            int num2 = nums1[ptr1] + nums2[ptr2 + 1];
            if (num1 < num2) {
                ptr1++;
                List<Integer> xx = new ArrayList<Integer>();
                xx.add(nums1[ptr1]);
                xx.add(nums2[ptr2]);
                result.add(xx);
            } else {
                ptr2++;
                List<Integer> xx = new ArrayList<Integer>();
                xx.add(nums1[ptr1]);
                xx.add(nums2[ptr2]);
                result.add(xx);
            }
        }
        return result;
    }
}


////////////////////////////////////////////////////////////////////////////////////////////////
//堆（优先队列）
class swd {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(k, (a, b) -> {  //优先队列储存两个下标,并保证堆顶元素的下标和最小
            return nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]];
        });
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //初始化优先队列
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            pq.add(new int[]{i, 0});
        }
        //
        while (result.size() < k && !pq.isEmpty()) {
            var cur = pq.poll();
            var list = new ArrayList<Integer>();
            list.add(nums1[cur[0]]);
            list.add(nums2[cur[1]]);
            result.add(list);
            if (cur[1] + 1 < nums2.length) {
                pq.add(new int[]{cur[0], cur[1] + 1});
            }
        }
        return result;
    }
}

