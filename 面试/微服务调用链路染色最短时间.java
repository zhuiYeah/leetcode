package 面试;

import java.util.*;


//华为第三题
public class 微服务调用链路染色最短时间 {
    static Set<Integer> visited = new HashSet<Integer>();
    static int[][] g;
    static int src;
    static Map<Integer, Integer> map;

    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();//服务器总数
        int n = sc.nextInt();
        g = new int[m][m];
        for (int i = 0; i < m; i++) {
            Arrays.fill(g[i], -1);
        }
        for (int i = 0; i < n; i++) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            int time = sc.nextInt();
            g[from][to] = time;
        }
        src = sc.nextInt() - 1;
        //求出从src起，能完成最多染色的总数，以及完成这些全部染色的最短时间
        dfs(src);
        System.out.println(visited.size());
        //计算遍历一个图中所有节点需要的最小代价
        map = new HashMap<Integer, Integer>(); //映射 染色完服务器i 的 最短时间
        for (int i : visited) map.put(i, Integer.MAX_VALUE);
        dddfffsss(src, 0);
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res = Math.max(res, entry.getValue());
        }
        System.out.println(res);
    }

    private static void dddfffsss(int cur, int time) {
        int cost = map.get(cur);
        if (time > cost) return;
        map.put(cur, time);
        for (int nxt = 0; nxt < g.length; nxt++) {
            if (nxt == cur) continue;
            if (g[cur][nxt] == -1) continue;
            int spinCost = g[nxt][nxt] == -1 ? 0 : g[nxt][nxt];
            dddfffsss(nxt, time + spinCost + g[cur][nxt]);
        }
    }

    private static void dfs(int cur) {
        if (visited.contains(cur)) return;
        visited.add(cur);
        for (int i = 0; i < g.length; i++) {
            if (g[cur][i] == -1) continue;
            dfs(i);
        }
    }
}
