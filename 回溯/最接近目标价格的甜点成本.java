package 回溯;

public class 最接近目标价格的甜点成本 {
    int res = 0;
    int target;
    int[] toppingCosts;
    int m;

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        res = baseCosts[0];
        m = toppingCosts.length;
        this.target = target;
        this.toppingCosts = toppingCosts;
        for (int baseCost : baseCosts) backtracking(0, baseCost);
        return res;
    }

    private void backtracking(int idx, int totCost) {
        if (idx == m) {
            if (Math.abs(totCost - target) < Math.abs(res - target)) {
                res = totCost;
            } else if ((Math.abs(totCost - target) == Math.abs(res - target)) && totCost < res) {
                res = totCost;
            }
            return;
        }
        if ((totCost - target) > Math.abs(res - target)) return;
        backtracking(idx + 1, totCost);
        backtracking(idx + 1, totCost + toppingCosts[idx]);
        backtracking(idx + 1, totCost + 2 * toppingCosts[idx]);
    }
}
