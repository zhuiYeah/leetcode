package 贪心;

import java.util.ArrayList;

public class 最大交换 {
    public int maximumSwap(int num) {
        var numArr = new ArrayList<Integer>();
        while (num != 0) {
            numArr.add(0, num % 10);
            num /= 10;
        }
        //num共有n位
        int n = numArr.size();
        for (int i = 0; i < n; i++) {
            int max = numArr.get(i) + 1; //这里加1非常关键，具体为什么自己体会
            int maxIndex = i;
            //这将找到i位之后 的 比i位大的 最大元素
            for (int j = i + 1; j < n; j++) {
                if (numArr.get(j) >= max) {
                    max = numArr.get(j);
                    maxIndex = j;
                }
            }
            //说明 后面的低位 确实有 比当前的高位 更大的数字
            if (maxIndex != i) {
                int tmp = numArr.get(i);
                numArr.set(i, max);
                numArr.set(maxIndex, tmp);
                break;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res *= 10;
            res += numArr.get(i);
        }
        return res;
    }
}
