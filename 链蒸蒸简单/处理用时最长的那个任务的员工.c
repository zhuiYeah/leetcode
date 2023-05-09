//
// Created by 爽 on 2023/5/5.
//
#include <string.h>

#define MAX(a, b) ((a) > (b) ? (a) : (b))

int hardestWorker(int n, int **logs, int logsSize, int *logsColSize) {
    int time[n];
    memset(time, 0, sizeof(time));
    int pre = 0;
    for (int i = 0; i < logsSize; i++) {
        int id = logs[i][0];
        int now = logs[i][1];
        time[id] = MAX(time[id], now - pre);
        pre = now;
    }
    int max = 0;
    int res = -1;
    for (int i = 0; i < n; i++) {
        if (time[i] > max) {
            max = time[i];
            res = i;
        }
    }
    return res;
}