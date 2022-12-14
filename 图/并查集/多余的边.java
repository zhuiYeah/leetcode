package 图.并查集;

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

    //初始化
    public void initialize() {
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }
    }

    //寻找父亲 节点
    public int find(int x) {
        if (x == father[x]) return x;
        father[x] = find(father[x]);
        return father[x];
    }

    //y所在的集群加入x所在的集群，顺序无所谓，其实就是合并两个集群
    public void join(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            father[y] = x;
        }
    }

    //x和y是否属于同一集群
    public boolean same(int x, int y) {
        x = find(x);
        y = find(y);
        return x == y;
    }

}
