package 图.树;
/**
 * 连通的n个节点 如果有且仅有 n - 1 个边 ， 那么一定可以构成树
 * <p>
 * n个节点的树 一定有且仅有 n - 1 个边
 * <p>
 * 树中的每一个节点都可以转换成根节点
 */


import java.util.Arrays;
import java.util.HashSet;

/**
 * 状态压缩 + 枚举 + dfs + 树的直径   2300+
 */
public class 统计子树中城市之间最大距离 {
    int[][] g;
    int n;

    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        this.n = n;
        g = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(g[i], Integer.MAX_VALUE); //Integer.MAX_VALUE 表示不能连通
        for (int i = 0; i < n; i++) g[i][i] = 0;
        for (int[] edge : edges) {
            int a = edge[0] - 1, b = edge[1] - 1;
            g[a][b] = g[b][a] = 1;
        }
        for (int i = 0; i < n; i++) dfs(i, i, -1, 0);
        //res[i]表示 直径为 i + 1 的子树的个数
        int[] res = new int[n - 1];
        //利用状态压缩 ， 枚举所有可能的组合
        for (int mask = 1; mask < 1 << n; mask++) {
            //先判断这个组合能不能组成子树
            if (!isVaild(mask)) continue;
            /**计算这个子树的直径*/
            var allTree = new HashSet<Integer>(); //储存子树中的下标
            for (int i = 0; i < n; i++) if ((mask & (1 << i)) != 0) allTree.add(i);
            if (allTree.size() == 1) continue;
            int x = 0; // x是子树中的任意一个点
            for (; x < n; x++) {
                if ((mask & (1 << x)) != 0) break;
            }
            //从x点出发找点距离x点最远的y点
            int y = 0;
            int maxDis = 0;
            for (int nxt : allTree) {
                if (g[nxt][x] > maxDis) {
                    maxDis = g[nxt][x];
                    y = nxt;
                }
            }
            //从y点出发找到距离y点最远的点z
            int z = 0;
            maxDis = 0;
            for (int nxt : allTree) {
                if (g[nxt][y] > maxDis) {
                    maxDis = g[nxt][y];
                    z = nxt;
                }
            }
            res[g[y][z]-1]++;
        }
        return res;
    }

    private int MASK; //仅用于isValid判断用

    private boolean isVaild(int mask) {
        int i = 0;
        for (; i < n; i++) {
            if ((mask & (1 << i)) != 0) break;
        }
        MASK = mask;
        dfsX(i, -1, mask);
        return MASK == 0;
    }

    //用户判断MASK能否组成一个连通
    private void dfsX(int cur, int from, int mask) {
        MASK -= 1 << cur;
        for (int nxt = 0; nxt < n; nxt++) {
            if (g[nxt][cur] != 1) continue;
            if (nxt == from) continue;
            if (((1 << nxt) & mask) == 0) continue;
            dfsX(nxt, cur, mask);
        }
    }

    //初始化g数组
    private void dfs(int START, int cur, int from, int step) {
        g[cur][START] = g[START][cur] = step;
        for (int nxt = 0; nxt < n; nxt++) {
            if (g[nxt][cur] != 1) continue;
            if (nxt == from) continue;
            dfs(START, nxt, cur, step + 1);
        }
    }
}

class test {
    public static void main(String[] args) {
        new 统计子树中城市之间最大距离().countSubgraphsForEachDiameter(2, new int[][]{{1, 2}});
    }
}
