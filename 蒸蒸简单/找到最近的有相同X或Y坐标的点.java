package 蒸蒸简单;

public class 找到最近的有相同X或Y坐标的点 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int idx = -1;
        int mindis = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                int dist = Math.abs(points[i][0] - x) + Math.abs(points[i][1] - y);
                if (dist < mindis) {
                    mindis = dist;
                    idx = i;
                }
            }
        }
        return idx;
    }
}
