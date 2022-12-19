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


//每日一题再写一次并查集
class dede {
    int[] father;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        initialize(n);
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            merge(a, b);
        }
        return isFamily(source, destination);
    }

    private void initialize(int size) {
        father = new int[size];
        for (int i = 0; i < father.length; i++) father[i] = i;
    }

    private int find(int x) {
        if (x == father[x]) return x;
        father[x] = find(father[x]);
        return father[x];
    }

    private void merge(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        father[a] = b;
    }

    private boolean isFamily(int a, int b) {
        a = find(a);
        b = find(b);
        return a == b;
    }

}
