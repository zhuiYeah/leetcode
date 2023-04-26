#include <string.h>

#define MAX(a, b) ((a) > (b) ? (a) : (b))

//动态规划
int longestArithSeqLength(int *nums, int numsSize) {
    int res = 2;
    int dp[numsSize][1005];
    //memset(dp, 1, sizeof(dp));
    for (int i = 0; i < numsSize; i++) {
        for (int j = 0; j < 1005; j++) {
            dp[i][j] = 1;
        }
    }

    //dp[i][j] ： 以nums[i]作为结尾，公差为j 的最长等差数列的长度
    for (int i = 1; i < numsSize; i++) {
        for (int j = 0; j < i; j++) {
            //nums[j] nums[i]的二元祖已经确定
            int diff = nums[i] - nums[j] + 500;
            dp[i][diff] = dp[j][diff] + 1; // j在这样的遍历顺序下，dp[i][diff]一定是递增的
            res = MAX(res, dp[i][diff]);
        }
    }
    return res;
}

int main() {
    int arr[] = {3, 6, 9, 12};
    longestArithSeqLength(arr, 4);
}


//纯暴力超时
int longestArithSeqLength2(int *nums, int numsSize) {
    int res = 2;
    for (int j = 1; j < numsSize; j++) {
        if (2 + numsSize - j - 1 <= res) continue;
        for (int i = 0; i < j; i++) {
            int x = 2, pre = nums[j], diff = nums[j] - nums[i];
            for (int k = j + 1; k < numsSize; k++) {
                if (nums[k] == pre + diff) {
                    pre = nums[k];
                    x++;
                }
            }
            res = MAX(res, x);
        }
    }
    return res;
}