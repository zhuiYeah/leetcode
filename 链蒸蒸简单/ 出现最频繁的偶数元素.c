#include <stdio.h>
#include <string.h>

int mostFrequentEven(int *nums, int numsSize) {
    int cnt[100005];
    //memset(cnt, 0, sizeof(int) * 100005);
    int res = -1;
    int maxfre = 0;
    for (int i = 0; i < numsSize; i++) {
        if (nums[i] % 2 == 1) continue;
        cnt[nums[i]]++;
    }
    for (int i = 0; i < 100005; i++) {
        if (cnt[i] > maxfre) {
            maxfre = cnt[i];
            res = i;
        }
    }
    return res;
}


int main() {
    int nums[] = {2, 2, 2, 4, 4, 4};
    int a = mostFrequentEven(nums, 6);
    printf("%d", a);
}