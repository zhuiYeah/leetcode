package 数学;

import java.util.HashMap;

//给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。


//对于double记录的斜率不能进行 == 运算的情况下 ， 用String记录double进行比较
public class 直线上最多的点数 {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;
        int max = 2;
        //映射  一条直线的斜率 与y轴交界的唯一点
        var line = new HashMap<String, String>();
        //选定两个点point[i],point[j]来确定一条直线，接下来遍历其他所有的点
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];
                double dx = x2 - x1, dy = y2 - y1;
                String oriPoint;
                String slope;
                if (dx == 0) {
                    oriPoint = "x=" + x1;
                    slope = "∞";
                } else if (dy == 0) {
                    oriPoint = "y=" + y1;
                    slope = "0";
                } else {
                    double k = dy / dx;
                    //与y轴的交点为newY
                    double newY = (double) y1 - k * (double) x1;
                    slope = String.valueOf(k);
                    oriPoint = String.valueOf(newY);
                }
                if (line.containsKey(slope) && line.get(slope).equals(oriPoint)) {
                    continue;
                } else {
                    line.put(slope, oriPoint);
                }
                int count = 2;
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) {
                        int x3 = points[k][0], y3 = points[k][1];
                        if ((x3 - x1) * dy == (y3 - y1) * dx) {
                            count++;
                        }
                    }
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
