package 回溯;

//将一些curIndex 和 curSum  放在回溯的参数列表中，再加上一些处理，可以使得回溯阶段无需做任何处理

public class 目标和 {
    int res;
    int n;
    int target;
    int[] nums;

    public int findTargetSumWays(int[] nums, int target) {
        n = nums.length;
        this.target = target;
        this.nums = nums;
        backtracking(0, 0);
        return res;
    }

    public void backtracking(int curIndex, int curSum) {
        if (curIndex == n) {
            if (curSum == target) {
                res++;
            }
            return;
        }
        backtracking(curIndex + 1, curSum + nums[curIndex]);

        backtracking(curIndex + 1, curSum - nums[curIndex]);

    }


}
