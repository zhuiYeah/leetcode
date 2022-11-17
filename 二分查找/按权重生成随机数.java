package 二分查找;

import java.util.Arrays;

//剑指offer
public class 按权重生成随机数 {
}

//前缀和  +  二分查找
class Solution {
    private int[] pre;
    private int sum;

    public Solution(int[] w) {
        pre = new int[w.length];
        pre[0] = w[0];
        for (int i = 1; i < w.length; i++) pre[i] = w[i] + pre[i - 1];
        sum = Arrays.stream(w).sum();
    }

    //随机返回w的下标之一 ， 必须按照权重随机化
    public int pickIndex() {
        int x = (int) (Math.random() * sum) + 1;
        return binSearch(x);
    }

    //找到第一个 pre[i] 使得pre[i] >= x
    //找到大于x的最小的pre[mid]的下标
    private int binSearch(int x) {
        int l = 0, r = pre.length - 1;
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (pre[mid] >= x) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}