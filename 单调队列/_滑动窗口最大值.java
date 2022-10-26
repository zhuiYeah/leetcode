package 单调队列;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

//O(n) , 对比堆的写法 是 nlogn
public class _滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        var res = new int[n - k + 1];
        //维护一个单调减少的双端队列，队列的头部就是滑动窗口的最大值
        var queue = new ArrayDeque<Integer>();
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) queue.pollLast();
            queue.add(i);
        }
        res[0] = nums[queue.peekFirst()];
        for (int i = k; i < n; i++) {
            //如果当前数字大于队列尾巴的数字，那么尾巴的数字就不可能是滑动窗口的最大值，直接poll（）
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) queue.pollLast();
            queue.add(i);
            //如果队列头部数字的下标不在滑动窗口之内，那么他不可能是滑动窗口的最大值，poll（）
            while (!queue.isEmpty() && queue.peekFirst() < i - k + 1) queue.pollFirst();
            res[i - k + 1] = nums[queue.peekFirst()];
        }
        return res;
    }

//    public void countAverage(double[][] nums) {
//        //L,a,b列的总和
//        double sumL = 0.0;
//        double sumA = 0.0;
//        double sumB = 0.0;
//        //数据一共有n行
//        int n = nums.length;
//
//        //averPerRow是个n行3列的数组，记录到该位置的平均值
//        var averPerRow = new ArrayList<double[]>();
//        for (int i = 0; i < n; i++) {
//            //当前在第i行，也就是说当前一共有i+1个数据要取平均值
//            for (int j = 0; j < 3; j++) {
//                sumL += nums[i][0];
//                sumA += nums[i][1];
//                sumB += nums[i][2];
//            }
//            //这是三列的当前平均值
//            double averL = sumL / (i + 1);
//            double averA = sumA / (i + 1);
//            double averB = sumB / (i + 1);
//
//            //将这三个平均值记录到averPerRow数组中
//            var averCurRow = new double[]{averL, averA, averB};
//            averPerRow.add(averCurRow);
//        }
//    }
}


class dewdqw {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        var res = new int[n - k + 1];
        var queue = new ArrayDeque<Integer>();
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) queue.pollLast();
            queue.add(i);
        }
        res[0] = nums[queue.peekFirst()];
        for (int i = k; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) queue.pollLast();
            queue.add(i);
            while (!queue.isEmpty() && queue.peekFirst() < i - k + 1) queue.pollFirst();
            res[i - k + 1] = nums[queue.peekFirst()];
        }
        return res;
    }
}
