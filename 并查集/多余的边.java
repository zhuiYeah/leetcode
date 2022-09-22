package 并查集;

public class 多余的边 {
    int[] father;

    public int[] findRedundantConnection(int[][] edges) {
        int[] father = new int[edges.length + 1];
        this.father = father;
        initialize();
        for (int i = 0; i < edges.length; i++) {
            if (same(edges[i][0], edges[i][1])) {
                return edges[i];
            } else {
                join(edges[i][0], edges[i][1]);
            }
        }
        return null;
    }

    public void initialize() {
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
        if (x != y) {
            father[y] = x;
        }
    }

    public boolean same(int x, int y) {
        x = find(x);
        y = find(y);
        return x == y;
    }

}
