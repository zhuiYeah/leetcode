package 状态压缩;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//bfs + 状态压缩
public class 获取所有钥匙的最短路径 {
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        int srcx = 0, srcy = 0;
        //映射 钥匙 -> 第几个钥匙
        Map<Character, Integer> keyindex = new HashMap<Character, Integer>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    srcx = i;
                    srcy = j;
                } else if (c >= 'a' && c <= 'z') {
                    if (!keyindex.containsKey(c)) {
                        int index = keyindex.size();
                        keyindex.put(c, index);
                    }
                }
            }
        }
        var queue = new ArrayDeque<int[]>();
        int num = keyindex.size();          //一共有num把钥匙，没把钥匙的标记位为0，1，2,...,num-1
        //mindis[i][j][mask]：到达i，j位置，携带钥匙的情况为mask，需要的最小距离为mindis[][][];
        int[][][] mindis = new int[m][n][1 << num];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(mindis[i][j], -1);
            }
        }
        queue.offer(new int[]{srcx, srcy, 0});//掩码0表示不持有任何一把钥匙
        mindis[srcx][srcy][0] = 0;
        while (!queue.isEmpty()) {
            var cur = queue.poll();
            int x = cur[0], y = cur[1], mask = cur[2], step = mindis[x][y][mask];
            for (int[] dir : dirs) {
                int nx = dir[0] + x, ny = dir[1] + y;
                if (nx < 0 || ny < 0 || nx >= m || ny >= n || grid[nx].charAt(ny) == '#') continue;
                char c = grid[nx].charAt(ny);
                //下一步是空房间或起点，且未以mask状态来过
                if ((c == '.' || c == '@') && mindis[nx][ny][mask] == -1) {
                    mindis[nx][ny][mask] = step + 1;
                    queue.offer(new int[]{nx, ny, mask});
                } else if (c >= 'a' && c <= 'z') {
                    //钥匙房间,确认这是第几把钥匙
                    int index = keyindex.get(c);
                    //mask修改为携带有index钥匙的状态（可能未修改）,如果未以那种状态进入nx，ny
                    if (mindis[nx][ny][mask | (1 << index)] == -1) {
                        mindis[nx][ny][mask | (1 << index)] = step + 1;
                        queue.offer(new int[]{nx, ny, mask | (1 << index)});
                        // (1 << keyindex.size()) - 1)是持有所有钥匙的掩码
                        if ((mask | (1 << index)) == (1 << keyindex.size()) - 1) return step + 1;
                    }
                } else if (c >= 'A' && c <= 'Z') {
                    //遇到锁,找到对应的钥匙，判断是否拥有该钥匙
                    int index = keyindex.get((char) (c + 32));
                    //如果当前拥有该钥匙，且未以当前状态mask进入下一步
                    if ((mask & (1 << index)) != 0 && mindis[nx][ny][mask] == -1) {
                        mindis[nx][ny][mask] = step + 1;
                        queue.offer(new int[]{nx, ny, mask});
                    }
                }
            }
        }
        return -1;
    }
}
