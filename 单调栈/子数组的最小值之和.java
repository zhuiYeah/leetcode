package 单调栈;

import java.util.ArrayDeque;
import java.util.Arrays;

//贡献法 + 乘法法则 + 单调栈
public class 子数组的最小值之和 {
    public int sumSubarrayMins(int[] arr) {
        final int MOD = (int) (1e9 + 7);
        int n = arr.length;
        var rmin = new int[n]; //右边第一个比我小的数字的下标
        var lmin = new int[n]; //左边第一个比我小的数字的下标
        Arrays.fill(lmin, -1);
        Arrays.fill(rmin, n);
        var stack = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                int index = stack.pop();
                rmin[index] = i;
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) lmin[stack.pop()] = i;
            stack.push(i);
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res = (res + ((long) (i - lmin[i]) * (rmin[i] - i) * arr[i])) % MOD;
        }
        return (int)res;
    }
}
