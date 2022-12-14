package 图.并查集;

public class 寻找图中是否存在路径 {
    int[] father;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        father = new int[n];
        initialize();
        for (int i = 0; i < edges.length; i++) {
            join(edges[i][0], edges[i][1]);
        }
        return same(source, destination);
    }

    public void initialize() {
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }
    }

    public int find(int x) {
        if (x == father[x]) {
            return x;
        }
        father[x] = find(father[x]);
        return father[x];
    }

    public void join(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return;
        father[y] = x;
    }

    public boolean same(int x, int y) {
        x = find(x);
        y = find(y);
        return x == y;
    }

}
