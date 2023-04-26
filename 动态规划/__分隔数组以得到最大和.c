#include <string.h>

#define MAX(a, b) ((a) > (b) ? (a) : (b))


int maxSumAfterPartitioning(int *arr, int arrSize, int k) {
    int dp[arrSize];
    memset(dp, 0, sizeof(dp)); //memset的第三个参数是字节数
    //dp[i] : i作为切割的结尾，可以得到的最大值为dp[i]
    int max = arr[0];
    for (int i = 0; i < k; i++) {
        max = MAX(max, arr[i]);
        dp[i] = max * (i + 1);
    }
    for (int i = k; i < arrSize; i++) {
        //现在计算dp[i]，往前回溯k位
        max = arr[i];
        for (int j = i; j >= i - k + 1; j--) {
            max = MAX(max, arr[j]);
            int tmp = max * (i - j + 1) + dp[j - 1];//tmp是dp【i】的可能取值之一
            dp[i] = MAX(dp[i], tmp);
        }
    }
    return dp[arrSize - 1];
}