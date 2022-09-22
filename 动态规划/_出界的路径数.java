package 动态规划;

import java.util.*;

//超出内存限制
public class _出界的路径数 {
    class struct {
        int x;
        int y;

        public struct(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int res = 0;
        Queue<struct> queue = new ArrayDeque<>();
        queue.add(new struct(startRow, startColumn));
        for (int i = 0; i < maxMove; i++) {
            int x = queue.size();
            for (int j = 0; j < x; j++) {
                struct cur = queue.poll();
                if (cur.x - 1 < 0) {
                    res++;
                } else {
                    queue.add(new struct(cur.x - 1, cur.y));
                }
                if (cur.x + 1 >= m) {
                    res++;
                } else {
                    queue.add(new struct(cur.x + 1, cur.y));
                }
                if (cur.y - 1 < 0) {
                    res++;
                } else {
                    queue.add(new struct(cur.x, cur.y - 1));
                }

                if (cur.y + 1 >= n) {
                    res++;
                } else {
                    queue.add(new struct(cur.x, cur.y + 1));
                }
            }
        }
        return res;
    }
}

//错误
class dewcewcfewc {
//    class struct {
//        int x;
//        int y;
//
//        public struct(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int res = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(startRow * n + startColumn, 1);
        for (int i = 0; i < maxMove; i++) {
            HashMap<Integer, Integer> tmp = new HashMap<>();
            for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
                int xx = entry.getKey();
                int row = xx / n;
                int col = xx % n;
                for (int[] dir : dirs) {
                    int x = row + dir[0];
                    int y = col + dir[1];
                    if (x < 0 || y < 0 || x >= m || y >= n) {
                        res += entry.getValue();
                        res = res % ((int) Math.pow(10, 9) + 7);
                    } else {
                        tmp.put(x * n + y, tmp.getOrDefault(x * n + y, 0) + 1);
                    }
                }
            }
            map.clear();
            map = (HashMap<Integer, Integer>) tmp.clone();
        }
        return res;
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        final int MOD = 1000000007;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int outCounts = 0;
        int[][][] dp = new int[maxMove + 1][m][n]; //定义 dp[i][j][k] 表示球移动 i 次之后位于坐标 (j,k) 的路径数量
        dp[0][startRow][startColumn] = 1;
        for (int i = 0; i < maxMove; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    int count = dp[i][j][k];
                    if (count > 0) {
                        for (int[] direction : directions) {
                            int j1 = j + direction[0], k1 = k + direction[1];
                            if (j1 >= 0 && j1 < m && k1 >= 0 && k1 < n) {
                                dp[i + 1][j1][k1] = (dp[i + 1][j1][k1] + count) % MOD;
                            } else {
                                outCounts = (outCounts + count) % MOD;
                            }
                        }
                    }
                }
            }
        }
        return outCounts;
    }
}
