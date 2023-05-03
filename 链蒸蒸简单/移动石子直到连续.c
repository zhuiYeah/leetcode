#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int cmp(const void* a, const void* b) {
    return *(int*)a - *(int*)b;
}

int* numMovesStones(int a, int b, int c, int* returnSize) {
    int stones[] = {a, b, c};
    qsort(stones, 3, sizeof(int), cmp);
    a = stones[0];
    b = stones[1];
    c = stones[2];
    *returnSize = 2;
    int* res = (int*)malloc(2 * sizeof(int));
    //memset(res, 0, sizeof(int) * 2);
    if (b - a == 1 && c - b == 1) {
        res[0] = res[1] = 0;
        return res;
    }
    if (b - a == 1) {
        res[0] = 1;
        res[1] = c - b - 1;
        return res;
    }
    if (c - b == 1) {
        res[0] = 1;
        res[1] = b - a - 1;
        return res;
    }
    if (b - a == 2) {
        res[0] = 1;
        res[1] = c - b;
        return res;
    }
    if (c - b == 2) {
        res[0] = 1;
        res[1] = b - a;
        return res;
    }
    res[0] = 2;
    res[1] = c - a - 2;
    return res;
}

int main() {
    int* res = (int*)malloc(10 * sizeof(int));
    printf("%lu\n", sizeof(res));
    // memset(res, 0, sizeof(res));

    int ans[10];
    printf("%lu\n", sizeof(ans));

    // for (int i = 0; i < 2; i++) {
    //     printf("%d\n", res[i]);
    // }
}