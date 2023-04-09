package 面试;

import java.util.Scanner;

/**
 * 图中有n个节点 n-1个边 ，每个边都有红蓝两色
 * 找出图中的颜色交替的最长路径
 * */
public class mihoyo2 {
    int[][] g;//表示图
    int res = 0;
    int N;//图中共有N个点 (1~n)，n-1个边


    public int maxRpute(int n, int[][] g) {
        N = n;
        this.g = g;
        //自己建图：g[i][j] 为 0 表示 i到j没有直接相连的路径  1表示红色  2表示蓝色
        for (int i = 1; i <= n; i++) {
            dfs(i, 1, 0);
            dfs(i, 2, 0);
        }
        return res;
    }

    private void dfs(int cur, int from, int route) {
        res = Math.max(res, route);
        //我当前在点cur，我来自于颜色from,我的下一个颜色必须是3-from
        for (int nxt = 1; nxt <= N; nxt++) {
            if (g[cur][nxt] != 3 - from) continue;
            dfs(nxt, 3 - from, route + 1);
        }
    }
}

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[][] g = new int[n + 1][n + 1];
            for (int i = 0; i < n - 1; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                String c = sc.next();
                g[a][b] = g[b][a] = c.charAt(0) == 'R' ? 1 : 2;
            }
            var res = new mihoyo2().maxRpute(n, g);
            System.out.println(res);
        }

    }
}


class dewwde{

}