package 堆;

import java.util.PriorityQueue;

//刚开始看题目的时候还不相信这道题是困难题
//堆无法直接在O(1)时间复杂度之内索引元素
//用两个堆（大顶堆存放小于中位数的元素，小顶堆存放大于中位数的元素），来实现对数据流中的中位数的索引
public class 堆_数据流中的中位数 {
    class MedianFinder {

        double mid = 0.0;
        //小顶堆存放大于mid的元素，大顶堆存放小于mid的元素，新增元素后重新计算mid
        PriorityQueue<Integer> pqMin = new PriorityQueue<Integer>((a, b) -> {
            return b - a;
        });
        PriorityQueue<Integer> pqMax = new PriorityQueue<Integer>();

        public MedianFinder() {
        }

        public void addNum(int num) {
            if (num < mid) {
                pqMin.add(num);
            } else {
                pqMax.add(num);
            }

            int maxSize = pqMax.size();
            int minSize = pqMin.size();
            if (maxSize - minSize == 1) {
                mid = pqMax.peek();
            } else if (minSize - maxSize == 1) {
                mid = pqMin.peek();
            } else if (maxSize == minSize) {
                mid = (double) pqMin.peek() + (double) pqMax.peek();
                mid /= 2.0;
            } else if (maxSize - minSize == 2) {
                while (pqMax.size() != pqMin.size()) {
                    pqMin.add(pqMax.poll());
                }
                mid = (double) pqMin.peek() + (double) pqMax.peek();
                mid /= 2.0;
            } else {
                while (pqMax.size() != pqMin.size()) {
                    pqMax.add(pqMin.poll());
                }
                mid = (double) pqMin.peek() + (double) pqMax.peek();
                mid /= 2.0;
            }
        }

        public double findMedian() {
            return mid;
        }
    }
}
