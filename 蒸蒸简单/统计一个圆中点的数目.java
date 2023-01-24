package 蒸蒸简单;

public class 统计一个圆中点的数目 {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];
        int i = -1;
        for (int[] q : queries) {
            i++;
            int x = q[0], y = q[1], r = q[2], cnt = 0;
            for (int[] p : points) if ((p[0] - x) * (p[0] - x) + (p[1] - y) * (p[1] - y) <= r * r) cnt++;
            res[i] = cnt;
        }
        return res;
    }
}
