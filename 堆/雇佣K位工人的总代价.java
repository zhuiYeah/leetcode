package 堆;

import java.util.PriorityQueue;

//来自318场周赛 wa两次
public class 雇佣K位工人的总代价 {
    PriorityQueue<Integer> pqFront;
    PriorityQueue<Integer> pqLast;

    public long totalCost(int[] costs, int k, int candidates) {
        long res = 0;
        int n = costs.length;
        pqFront = new PriorityQueue<Integer>((a, b) -> {
            if (costs[a] == costs[b]) {
                return a - b;
            } else {
                return costs[a] - costs[b];
            }
        });
        pqLast = new PriorityQueue<Integer>((a, b) -> {
            if (costs[a] == costs[b]) {
                return a - b;
            } else {
                return costs[a] - costs[b];
            }
        });
        if (2 * candidates >= n) {
            for (int i = 0; i < n; i++) pqFront.add(i);
        } else {
            for (int i = 0; i < candidates; i++) pqFront.add(i);
            for (int i = n - 1; i > n - 1 - candidates; i--) pqLast.add(i);
        }
        int ptrFont = candidates;
        int ptrLast = n - 1 - candidates;
        for (int i = 0; i < k; i++) {
            if (pqLast.isEmpty()) {
                res += costs[(pqFront.poll())];
                continue;
            }
            if (costs[pqFront.peek()] > costs[pqLast.peek()]) {
                res += costs[pqLast.poll()];
                if (ptrFont == ptrLast) {
                    update();
                    pqFront.add(ptrFont);
                    ptrFont = 0;
                    ptrLast = -1;
                } else {
                    pqLast.add(ptrLast);
                    ptrLast--;
                }
            } else {
                res += costs[pqFront.poll()];
                if (ptrFont == ptrLast) {
                    update();
                    pqFront.add(ptrFont);
                    ptrFont = 0;
                    ptrLast = -1;
                } else {
                    pqFront.add(ptrFont);
                    ptrFont++;
                }
            }
        }
        return res;
    }

    private void update() {
        while (!pqLast.isEmpty()) {
            pqFront.add(pqLast.poll());
        }
    }

}
