//
// Created by 爽 on 2023/5/4.
//


#include <iostream>
#include <cstring>

using namespace std;

const int INF = 0x3f3f3f3f;
const int MAXN = 105;
int res = INF;
int m, n;
int g[MAXN][MAXN];
const int DIRT[4][2] = {{1,  0},
                        {-1, 0},
                        {0,  1},
                        {0,  -1}};

void dfs(int x, int y, int cost);

int main() {
    cin >> m >> n;
    int X;
    cin >> X;
    for (int i = 0; i < MAXN; i++) {
        for (int j = 0; j < MAXN; j++) {
            g[i][j] = -1;
        }
    }
    g[0][0] = 1;
    for (int k = 0; k < X; k++) {
        int i, j, cost;
        cin >> i >> j >> cost;
        g[i][j] = cost;
    }
    dfs(0, 0, 0);
    if (res == INF) cout << -1 << endl;
    else cout << res << endl;
    return 0;
}

void dfs(int x, int y, int cost) {
    if (x == m - 1 && y == n - 1) {
        res = min(res, cost);
        return;
    }
    if (x < 0 || x >= m || y < 0 || y >= n || g[x][y] == -1) return;
    for (int i = 0; i < 4; i++) {
        int nxtX = x + DIRT[i][0], nxtY = y + DIRT[i][1];
        int tmp = g[x][y];
        g[x][y] = -1;
        dfs(nxtX, nxtY, cost + tmp);
        g[x][y] = tmp;
    }
}
