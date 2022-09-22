package 排序;

import java.util.PriorityQueue;

//给n个运动员按照他们的分数授予名次，运动员的位置不能变
public class 堆_相对名次 {
    public static String[] findRelativeRanks(int[] score) {
        //共有n个运动员
        int n = score.length;
        var res = new String[n];
        //优先队列储存运动员的序号，按照运动员的得分来构造一个大顶堆
        var pq = new PriorityQueue<Integer>((a, b) -> {
            return score[b] - score[a];
        });
        for (int i = 0; i < n; i++) {
            pq.add(i);
        }
        int level = 1;
        while (!pq.isEmpty()) {
            if (level == 1) {
                res[pq.poll()] = "Gold Medal";
            } else if (level == 2) {
                res[pq.poll()] = "Silver Medal";
            } else if (level == 3) {
                res[pq.poll()] = "Bronze Medal";
            } else {
                res[pq.poll()] = String.valueOf(level);
            }
            level++;
        }
        return res;
    }

    public static void main(String[] args) {
        findRelativeRanks(new int[]{3, 2, 1});
    }
}
