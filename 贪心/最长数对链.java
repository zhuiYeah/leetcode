package 贪心;

import java.util.Arrays;

//O(n*log n)
public class 最长数对链 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]); //按照边界从小到达排序已满足贪心
        int res = 1; //记录最大数对链的个数
        int end = pairs[0][1]; //记录边界，下一个数对的开始必须大于边界才能链上

        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > end) {
                end = pairs[i][1];
                res++;
            }
        }
        return res;
    }
}
