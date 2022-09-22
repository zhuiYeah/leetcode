package 数学;

public class 优美的排列_回溯 {
    boolean[] used;
    int n;
    int res;

    public int countArrangement(int n) {
        boolean[] used = new boolean[n + 1];
        this.used = used;
        this.n = n;
        backtracking(1);
        return res;
    }

    public void backtracking(int curIndex) {//curIndex表示当前需要选择优美排列的第curIndex个元素
        if (curIndex == n + 1) {
            res++;
            return;
        }
        for (int i = 1; i <= n; i++) { //i表示选择的元素
            if (!used[i] && (i % curIndex == 0 || curIndex % i == 0)) {
                used[i] = true;
            } else {
                continue;
            }
            backtracking(curIndex+1);
            used[i] = false;
        }
    }

}
