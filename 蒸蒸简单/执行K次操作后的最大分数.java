package 蒸蒸简单;

import java.util.PriorityQueue;

//模拟 + 优先队列
public class 执行K次操作后的最大分数 {
    public long maxKelements(int[] nums, int k) {
        var pq = new PriorityQueue<Integer>((a, b) -> b - a);
        long score = 0;
        for (int i : nums) pq.add(i);
        for (int i = 0; i < k; i++) {
            int x = pq.poll();
            score += x;
            pq.add((int) Math.ceil(x / 3.0));
        }

        return score;
    }

    public static void main(String[] args) {
        int x = 1;
        System.out.println((int) Math.ceil(x / 10000000000000.0));
    }
}



