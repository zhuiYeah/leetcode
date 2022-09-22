package 贪心;

import java.util.Arrays;

//字节一面
//Arrays.stream(candy).sum() 5ms
//自己中途计算sum  2ms
public class 分发糖果 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        var candy = new int[n];
        candy[0] = 1;
        //左条件
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            } else {
                candy[i] = 1;
            }
        }
        int res = candy[n - 1];
        //右条件
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                int maybe = candy[i + 1] + 1;
                candy[i] = Math.max(candy[i], maybe);
            }
            res += candy[i];
        }
        return res;

    }
}
