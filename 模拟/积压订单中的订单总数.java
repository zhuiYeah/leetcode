package 模拟;

import java.util.HashMap;
import java.util.PriorityQueue;


//模拟 + 堆

//类型为0的订单需要大于等于类型为1的订单才能消消乐
public class 积压订单中的订单总数 {

    public int getNumberOfBacklogOrders(int[][] orders) {
        //类型为0的订单价格从高到低排列
        var type0 = new PriorityQueue<int[]>((a, b) -> b[0] - a[0]);
        //类型为1的订单价格从低到高排列
        var type1 = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);

        for (int[] order : orders) {
            if (order[2] == 0) {
                int amout = order[1], price = order[0];
                while (amout > 0 && type1.size() != 0 && price >= type1.peek()[0]) {
                    int[] x = type1.poll();
                    int price1 = x[0], amout1 = x[1];
                    if (amout < amout1) {
                        amout1 -= amout;
                        amout = 0;
                        type1.offer(new int[]{price1, amout1});
                        continue;
                    }
                    amout -= amout1;
                }
                if (amout > 0) {
                    type0.offer(new int[]{price, amout});
                }
            } else {
                int amout1 = order[1], price1 = order[0];
                while (amout1 > 0 && type0.size() != 0 && price1 <= type0.peek()[0]) {
                    int[] x = type0.poll();
                    int amout0 = x[1], price0 = x[0];
                    if (amout1 < amout0) {
                        amout0 -= amout1;
                        amout1 = 0;
                        type0.offer(new int[]{price0, amout0});
                        continue;
                    }
                    amout1 -= amout0;
                }
                if (amout1 > 0) {
                    type1.offer(new int[]{price1, amout1});
                }
            }
        }
        long res = 0;
        final int MOD = (int) (1e9 + 7);
        while (type0.size() != 0)
            res = (res + type0.poll()[1]) % MOD;
        while (type1.size() != 0)
            res = (res + type1.poll()[1]) % MOD;
//        while (!type0.isEmpty() && !type1.isEmpty() && type0.peek()[0] >= type1.peek()[0]) {
//            int[] x0 = type0.poll();
//            int[] x1 = type1.poll();
//
//
//        }

        return (int) res;
    }
}


class dfrewfre {
    public static void main(String[] args) {
        int[][] order = new int[][]{{7, 1000000000, 1}, {15, 3, 0}, {5, 999999995, 0}, {5, 1, 1}};
        var x = new 积压订单中的订单总数().getNumberOfBacklogOrders(order);
    }
}
