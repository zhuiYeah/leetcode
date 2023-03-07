package 记忆化搜索;

/**
 * 爱丽丝和鲍勃继续他们的石子游戏。许多堆石子 排成一行，每堆都有正整数颗石子 piles[i]。游戏以谁手中的石子最多来决出胜负。
 * <p>
 * 爱丽丝和鲍勃轮流进行，爱丽丝先开始。最初，M = 1。
 * <p>
 * 在每个玩家的回合中，该玩家可以拿走剩下的 前 X 堆的所有石子，其中 1 <= X <= 2M。然后，令 M = max(M, X)。
 * <p>
 * 游戏一直持续到所有石子都被拿走。
 * <p>
 * 假设爱丽丝和鲍勃都发挥出最佳水平，返回爱丽丝可以得到的最大数量的石头。
 */
public class _石子游戏II {
    int[][] cache;//记忆化搜索的缓存
    int n;
    int[] s;//后缀和

    public int stoneGameII(int[] piles) {
        n = piles.length;
        cache = new int[n][10001];
        s = piles;
        for (int i = n - 2; i >= 0; i--) s[i] += s[i + 1];
        return dfs(0, 1);
    }

    //alice or bob 现在 在下标为i的石头处抉择取 [1,2*m]堆石头,能取得的最大值为dfs(i,m)
    //能取得的最大值，其实就是 当前位置的后缀和 - 下一个玩家的最好发挥
    private int dfs(int i, int m) {
        if (cache[i][m] != 0) return cache[i][m];
        //如果当前玩家能全部拿光，那么他一定全部拿光
        if (i + 2 * m >= n) {
            cache[i][m] = s[i];
            return s[i];
        }
        //当前玩家取x个，下一个玩家从 i+x下标开始取，能取到的最大值 nxt = dfs（i+x，max(m,x)）
        //而当前玩家的能得到的分数为 s[i] - nxt ,所以当nxt取得最小值时，当前玩家取最大值
        int nxt = Integer.MAX_VALUE;
        for (int x = 1; x <= 2 * m; x++)
            nxt = Math.min(nxt, dfs(i + x, Math.max(m, x)));
        cache[i][m] = s[i] - nxt;
        return cache[i][m];
    }
}
