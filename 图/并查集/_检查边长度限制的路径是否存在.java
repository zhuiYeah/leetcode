package 图.并查集;


import java.util.Arrays;

//离线询问  + 图.并查集 + 贪心
public class _检查边长度限制的路径是否存在 {
    int[] fa;

    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        fa = new int[n];
        init();
        int k = queries.length;
        var res = new boolean[k];
        var queriesId = new Integer[k];
        for (int i = 0; i < k; i++) queriesId[i] = i;
        //queriesId绑定了queries，并按照queries所带的权从小到大排序
        Arrays.sort(queriesId, (a, b) -> queries[a][2] - queries[b][2]);
        //将图中的边由小到大排序
        Arrays.sort(edgeList, (a, b) -> a[2] - b[2]);
        int ptr = 0; //该指针用于指向未进行 并查集处理 的edgeList的第一个下标
        for (int id : queriesId) {
            int quan = queries[id][2];
            //只要当前查询所带的权 大于 边的代价，这条边对于本次查询就是可以通过的，将这条边的两个节点所在的集群合并
            while (ptr < edgeList.length && quan > edgeList[ptr][2]) {
                int a = edgeList[ptr][0], b = edgeList[ptr][1];
                join(a, b);
                ptr++;
            }
            //最后，判断本次查询的两个节点在当前权下 是否处于同一个集群
            res[id] = isSame(queries[id][0], queries[id][1]);
        }

        return res;
    }

    private void init() {
        for (int i = 0; i < fa.length; i++) fa[i] = i;
    }

    //找到x的父节点
    private int find(int x) {
        if (x == fa[x]) return x;
        fa[x] = find(fa[x]);
        return fa[x];
    }

    //将from所在的集群 和 to所在的集群 合并，顺序无所谓
    private void join(int from, int to) {
        from = find(from);
        to = find(to);
        if (from != to) {
            fa[from] = to;
        }
    }

    //判断a、b节点是否属于同一集群
    private boolean isSame(int a, int b) {
        a = find(a);
        b = find(b);
        return a == b;
    }
}
