package 堆;

/**
 * 你有 k 个背包。给你一个下标从 0 开始的整数数组 weights ，其中 weights[i] 是第 i 个珠子的重量。同时给你整数 k 。
 * <p>
 * 请你按照如下规则将所有的珠子放进 k 个背包。
 * <p>
 * 没有背包是空的。
 * 如果第 i 个珠子和第 j 个珠子在同一个背包里，那么下标在 i 到 j 之间的所有珠子都必须在这同一个背包中。
 * 如果一个背包有下标从 i 到 j 的所有珠子，那么这个背包的价格是 weights[i] + weights[j] 。
 * 一个珠子分配方案的 分数 是所有 k 个背包的价格之和。
 * <p>
 * 请你返回所有分配方案中，最大分数 与 最小分数 的 差值 为多少。
 * <p>
 * <p>
 * 输入：weights = [1,3,5,1], k = 2
 * 输出：4
 * 解释：
 * 分配方案 [1],[3,5,1] 得到最小得分 (1+1) + (3+1) = 6 。
 * 分配方案 [1,3],[5,1] 得到最大得分 (1+3) + (5+1) = 10 。
 * 所以差值为 10 - 6 = 4 。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

//t3 hard  思维 + 堆

//将数组分成k个子数组，那么相当于切k-1刀 ， weight[0]和weight[n-1]必然会统计进入得分 ， 之后切k-1刀。遍历所有刀 ， 用堆存放最大的k-1刀和最小的k-1刀
public class _将珠子放入背包中 {
    public long putMarbles(int[] weights, int k) {
        if (k == 1) return 0;
        var pqMax = new PriorityQueue<Integer>((a, b) -> b - a);//大顶堆存放最小的k-1个元素
        var pqMin = new PriorityQueue<Integer>();
        long sum_of_max_k = 0, sum_of_min_k = 0;
        for (int i = 0; i < weights.length - 1; i++) {
            int score = weights[i] + weights[i + 1];
            if (pqMax.size() == k - 1) {
                if (score < pqMax.peek()) {
                    sum_of_min_k -= pqMax.poll();
                    sum_of_min_k += score;
                    pqMax.add(score);
                }
            } else {
                pqMax.add(score);
            }
            if (pqMin.size() == k - 1) {
                if (score > pqMin.peek()) {
                    sum_of_max_k -= pqMin.poll();
                    sum_of_max_k += score;
                    pqMin.add(score);
                }
            } else {
                pqMin.add(score);
            }
        }
        return sum_of_max_k - sum_of_min_k;
    }
}


class dedew {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        for (int i = 0; i < n - 1; i++)
            weights[i] += weights[i + 1];
        var score = new ArrayList<Integer>();
        for (int i = 0; i < n - 1; i++)
            score.add(weights[i]);
        score.sort((a, b) -> a - b);
        long sumMax = 0, sumMin = 0;
        for (int i = 0; i < k - 1; i++) {
            sumMin += score.get(i);
            sumMax += score.get(n - 2 - i);
        }
        return sumMax - sumMin;
    }
}
