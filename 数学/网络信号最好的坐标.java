package 数学;


//几何 + 枚举 枚举所有可能的点
public class 网络信号最好的坐标 {
    public int[] bestCoordinate(int[][] towers, int radius) {
        int maxp = 0;
        int resx = 0;
        int resy = 0;
        int mx = 0;
        int my = 0;
        for (int[] tower : towers) {
            mx = Math.max(mx, tower[0]);
            my = Math.max(my, tower[1]);
        }

        for (int x = mx; x >= 0; x--) {
            for (int y = my; y >= 0; y--) {
                int p = 0;
                for (int[] tartow : towers) {
                    double d = Math.sqrt((x - tartow[0]) * (x - tartow[0]) + (y - tartow[1]) * (y - tartow[1]));
                    if (d <= radius) {
                        p += tartow[2] / (1 + d);
                    }
                }
                if (p >= maxp) {
                    maxp = p;
                    resx = x;
                    resy = y;
                }
            }
        }
        return new int[]{resx, resy};
    }
}
//
//else if (p == maxp) {
//        if (x < resx || (x == resx && y < resy)) {
//        resx = x;
//        resy = y;
//        }
//        }