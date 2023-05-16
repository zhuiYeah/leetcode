//
// Created by gaoshuang on 2023/5/16.
//
#include <stdlib.h>
#include <stdio.h>

#define MAX(a, b) ((a) > (b) ? (a): (b))
#define MIN(a, b) ((a) < (b)? (a): (b))


int minDifficulty(int *jobDifficulty, int jobDifficultySize, int d) {
    int dp[jobDifficultySize][d]; //dp[i][j] : 第j天以第i个任务收尾，得到的最小代价为
    if (d > jobDifficultySize) return -1;
    for (int i = 0; i < jobDifficultySize; i++) {
        for (int j = 0; j < d; j++) {
            dp[i][j] = 0x3f3f3f3f;
        }
    }
    int MAXCOST[jobDifficultySize][jobDifficultySize];
    for (int i = 0; i < jobDifficultySize; i++) {
        int max = jobDifficulty[i];
        for (int j = i; j < jobDifficultySize; j++) {
            max = MAX(max, jobDifficulty[j]);
            MAXCOST[i][j] = max;
        }
    }
    for (int i = 0; i < jobDifficultySize; i++) dp[i][0] = MAXCOST[0][i];
    for (int j = 1; j < d; j++) {
        for (int i = 0; i < jobDifficultySize; i++) {
            for (int k = 0; k < i; k++) {
                dp[i][j] = MIN(dp[i][j], dp[k][j - 1] + MAXCOST[k + 1][i]);
            }
        }
    }
    return dp[jobDifficultySize - 1][d - 1];
}


int main() {
    int *x = malloc(sizeof(int) * 6);
    x[0] = 6;
    x[1] = 5;
    x[2] = 4;
    x[3] = 3;
    x[4] = 2;
    x[5] = 1;
    int res = minDifficulty(x, 6, 2);
    printf("%d\n",res);
}