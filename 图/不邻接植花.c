//
// Created by 爽 on 2023/4/28.
//
#include  <stdlib.h>
#include <string.h>


int getColor(int cur, int *color,int *gSize, int g[][3]) {
    int canColor[] = {1, 1, 1, 1, 1};
    for (int i = 0; i < gSize[cur]; i++) {
        int nxt = g[cur][i];
        int idx = color[nxt];
        canColor[idx] = 0;
    }
    for (int c = 1; c <= 4; c++) {
        if (canColor[c]) return c;
    }
    return -1;
}

void dfs(int cur, int *color, int *gSize, int g[][3]) {
    if (color[cur] != 0) return;
    color[cur] = getColor(cur, color, gSize, g);
    for (int i = 0; i < gSize[cur]; i++) {
        int nxt = g[cur][i];
        dfs(nxt, color, gSize, g);
    }
}

int *gardenNoAdj(int n, int **paths, int pathsSize, int *pathsColSize, int *returnSize) {
    int *res = malloc(n * sizeof(int));
    int g[n][3], gSize[n];
    memset(res, 0, n * sizeof(int));
    memset(gSize, 0, n * sizeof(int));
    for (int i = 0; i < pathsSize; i++) {
        int x = paths[i][0] - 1, y = paths[i][1] - 1;
        g[x][gSize[x]++] = y;
        g[y][gSize[y]++] = x;
    }
    *returnSize = n;
    for (int i = 0; i < n; i++) dfs(i, res, gSize, g);
    return res;
}

int main() {
    int* res = (int*)malloc(2 * sizeof(int));
    memset(res, 0, 2 * sizeof(int));
    for (int i = 0; i < 2; i++) {
        printf("%d\n", res[i]);
    }
}