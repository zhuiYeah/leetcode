package 并查集;

public class 省份数量 {
    // 节点i属于集群father[i]
    int[] father;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        father = new int[n];
        init();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) join(i, j);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (father[i] == i) {
                count++;
            }
        }
        return count;
    }

    public void init() {
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }
    }

    public int find(int x) {
        if (x == father[x]) return x;
        father[x] = find(father[x]);
        return father[x];
    }

    public void join(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return;
        father[y] = x;
    }

}
