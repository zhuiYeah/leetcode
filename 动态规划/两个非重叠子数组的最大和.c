#include <string.h>
#include <stdio.h>
#include <stdlib.h>

# define MAX(a, b) ((a)>(b)?(a):(b))

int maxSumTwoNoOverlap(int *nums, int numsSize, int firstLen, int secondLen) {
    int n = numsSize;
    int ps[n + 1];//前缀和
    for (int i = 0; i < n; i++) ps[i + 1] = ps[i] + nums[i];
    int a[n + 1], b[n + 1]; //a[i] : 前i个数中，长为firstLen的子数组的最大和
    memset(a, 0, sizeof(a));
    memset(b, 0, sizeof(b));
    int ans = 0;
    for (int i = 1; i <= n; i++) {//前i个数字
        if (i >= firstLen + secondLen) {
            ans = MAX(ans, ps[i] - ps[i - firstLen] + b[i - firstLen]);
            ans = MAX(ans, ps[i] - ps[i - secondLen] + a[i - secondLen]);
        }
        if (i >= firstLen) a[i] = MAX(a[i - 1], ps[i] - ps[i - firstLen]);
        if (i >= secondLen) b[i] = MAX(b[i - 1], ps[i] - ps[i - secondLen]);
    }
    return ans;
}

int main() {
    int n = 66;
    int ps[n + 1];
    int* pss = malloc((n + 1) * sizeof(int));
    printf("%lu\n", sizeof(ps));
    printf("%lu\n", sizeof(pss));
    for (int i = 0; i <= n; i++) printf("%d ", ps[i]);
}