package 排序;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 堆_雇佣K名工人的最低成本_堆 {
    public static double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        //共有n个工人
        int n = quality.length;
        double totalSal = Integer.MAX_VALUE;
        //存放所有工人的下标，按照 每单位工作质量的工资 由低到高进行排序 , 排序越靠前的工人性价比越高
        var employeeID = new Integer[n];
        for (int i = 0; i < n; i++) {
            employeeID[i] = i;
        }
        Arrays.sort(employeeID, (a, b) -> {
            return wage[a] * quality[b] - wage[b] * quality[a];
        });
        //例如，当前的 每单位工作质量工资 为 x ， 那么优先队列存放小于x的工人的工作质量
        //也就是说，在给定每单位工作质量工资的情况下，总工作质量越低，要支付给工人的总工资越小
        //所以优先队列存放条件的 前k-1小的工作质量（大顶堆）
        var pq = new PriorityQueue<Integer>((a, b) -> {
            return b - a;
        });
        double totalq = 0.0;
        //将优先队列的元素个数先填满至k-1个，也就是说，只差一个工人就能招满了
        for (int i = 0; i < k - 1; i++) {
            totalq += quality[employeeID[i]];
            pq.offer(quality[employeeID[i]]);
        }
        for (int i = k - 1; i < n; i++) {
            int index = employeeID[i]; //得到当前工人的下标，当前工人的 每单位工作质量工资 将成为基准
            double unitSalary = (double) wage[index] / (double) quality[index];
            pq.offer(quality[index]);
            totalq += quality[index];
            totalSal = Math.min(totalSal, unitSalary * totalq);
            totalq -= pq.poll();
        }
        return totalSal;
    }
}
