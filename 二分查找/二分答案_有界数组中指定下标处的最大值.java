package 二分查找;

/**
 * 给你三个正整数 n、index 和 maxSum 。你需要构造一个同时满足下述所有条件的数组 nums（下标 从 0 开始 计数）：
 * <p>
 * nums.length == n
 * nums[i] 是 正整数 ，其中 0 <= i < n
 * abs(nums[i] - nums[i+1]) <= 1 ，其中 0 <= i < n-1
 * nums 中所有元素之和不超过 maxSum
 * nums[index] 的值被 最大化
 * 返回你所构造的数组中的 nums[index] 。
 **/

public class 二分答案_有界数组中指定下标处的最大值 {
    int index;
    int N;
    int MAX;

    public int maxValue(int n, int index, int maxSum) {
        this.index = index;
        N = n - 1;
        MAX = maxSum;
        int left = 1;
        int right = (int) Math.pow(10, 9);
        //int right = 100;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canFuckYou(mid)) {
                res = Math.max(res, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }

    //index位置的值为x，能满足maxsum的限制吗?
    private boolean canFuckYou(int x) {
        int l = index - (x - 1);//左边初次得到1的下标
        int r = index + (x - 1);//右边初次得到1的下标
        long cost = 0;
        if (l < 0) {
            int zeroIndexValue = x - index;
            cost += (long) (zeroIndexValue + x) * (index + 1) / 2;
        } else {
            cost += (long) (1 + x) * (index - l + 1) / 2;
            cost += l;
        }

        if (r > N) {
            int NIndexValue = x - (N - index);
            cost += (long) (x + NIndexValue) * (N - index + 1) / 2;
        } else {
            cost += (long) (1 + x) * (r - index + 1) / 2;
            cost += N - r ;
        }
        cost -= x;
        return cost <= MAX;
    }

}

class cevcer {
    public static void main(String[] args) {
        var x = new 二分答案_有界数组中指定下标处的最大值().maxValue(4, 0, 4);
    }
}
