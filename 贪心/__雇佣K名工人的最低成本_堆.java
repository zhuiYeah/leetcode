package 贪心;

import java.util.Arrays;
import java.util.PriorityQueue;

//需要雇佣k名工人，每名工人的工作质量和期望薪资已给出 ， 必须按照每名工人的工作质量按照比例发放工资， 必须满足每个工人的期望薪资
//给出雇佣k名工人的最低成本

//利用重叠子问题
class defdewfce {
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
        //例如，当前的 每单位工作质量工资 为 x ， 那么优先队列存放 期望工资小于x 的工人的 工作质量
        //也就是说，在给定每单位工作质量工资的情况下，总工作质量越低，要支付给工人的总工资越小
        //所以优先队列存放条件的 前k-1小的工作质量（大顶堆）
        var pq = new PriorityQueue<Integer>((a, b) -> {
            return b - a;
        });
        double totalq = 0.0; //总工作质量
        //将优先队列的元素个数先填满至k-1个，也就是说，只差一个工人就能招满了
        for (int i = 0; i < k - 1; i++) {
            totalq += quality[employeeID[i]];
            pq.offer(quality[employeeID[i]]);
        }
        for (int i = k - 1; i < n; i++) {
            int index = employeeID[i]; //得到当前工人的下标，当前工人的 每单位工作质量工资 将成为基准，当前工人必须被雇佣
            //unitSalary一定是单调递增的
            double unitSalary = (double) wage[index] / (double) quality[index];
            pq.offer(quality[index]);
            totalq += quality[index];
            totalSal = Math.min(totalSal, unitSalary * totalq);
            totalq -= pq.poll(); //去掉一个工作质量最高的工人，即工资最高的工人（实发工资，非本人要求工资）
        }
        return totalSal;
    }
}


//float精度不够  ，改成 double解决
//超时 ， 有很多重叠子问题
public class __雇佣K名工人的最低成本_堆 {
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
        if (k == 1) {
            Arrays.sort(wage);
            return wage[0];
        }
        //例如，当前的 每单位工作质量工资 为 x ， 那么优先队列存放小于x的工人的工作质量
        //也就是说，在给定每单位工作质量工资的情况下，总工作质量越低，要支付给工人的总工资越小
        //所以优先队列存放条件的 前k-1小的工作质量（大顶堆）
        var pq = new PriorityQueue<Integer>((a, b) -> {
            return b - a;
        });
        for (int i = 0; i < n; i++) {
            int index = employeeID[i];
            //给定 工人employee[i] 单位工作质量的工资 ，工人i作为基准必须被雇佣 ， 还需雇佣k-1个工人
            //float unitSalary = (float) wage[index] / (float) quality[index];（这里损失了精度）
            //小于等于当前单位工资的才能被雇佣（进入优先队列）
            for (int j = 0; j < i; j++) {
                if (pq.size() < k - 1) {
                    pq.add(quality[employeeID[j]]);
                } else {
                    if (quality[employeeID[j]] < pq.peek()) {
                        pq.poll();
                        pq.add(quality[employeeID[j]]);
                    }
                }
            }
            if (pq.size() == k - 1) {
                int totalQuality = quality[index];
                while (!pq.isEmpty()) {
                    totalQuality += pq.poll();
                }
                totalSal = Math.min(totalSal, (double) wage[index] * (double) totalQuality / (double) quality[index]);
            } else {
                pq.clear();
            }
        }
        return totalSal;
    }

    public static void main(String[] args) {
        int[] quality = new int[]{10, 20, 5};
        int[] wage = new int[]{70, 50, 30};
        mincostToHireWorkers(quality, wage, 2);
    }
}


//////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////
