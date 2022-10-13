package 模拟;

import java.util.HashSet;
import java.util.Set;

//  50/54 超时
public class 机器人大冒险 {
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        if (x == 0 && y == 0) {
            return true;
        }
        Set<String> obs = new HashSet<String>();
        for (int[] obstacle : obstacles) {
            obs.add(obstacle[0] + "-" + obstacle[1]);
        }
        int xx = 0, yy = 0;
        while (true) {
            for (int i = 0; i < command.length(); i++) {
                if (command.charAt(i) == 'U') {
                    yy++;
                } else {
                    xx++;
                }
                if (obs.contains(xx + "-" + yy)) return false;
                if (xx > x || yy > y) return false;
                if (xx == x && yy == y) return true;
            }
        }
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////
//难点在于如何将另一个区间的点平移至初始区间 ，以及障碍物的影响判定
class dedfewfcewvcew {
    public static boolean robot(String command, int[][] obstacles, int x, int y) {
        //在一次循环中总的向右移动的次数 和 向上移动的次数
        int totalR = 0, totalU = 0;
        //point储存了机器人在第0个循环内经过的所有点
        var point = new HashSet<String>();
        point.add(0 + "-" + 0);
        int curx = 0, cury = 0;
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'U') {
                totalU++;
                cury++;
            } else {
                curx++;
                totalR++;
            }
            point.add(curx + "-" + cury);
        }

        int circle = Math.min(x / totalR, y / totalU);
        ///(xxx,yyy)表示（x，y）落在第0个循环内的点
        int xxx = x - circle * totalR;
        int yyy = y - circle * totalU;
        if (!point.contains(xxx + "-" + yyy)) return false;
        //现在，如果没有障碍点的话，机器人可以到达终点
        //接下来检查障碍点
        for (int[] obstacle : obstacles) {
            int xx = obstacle[0], yy = obstacle[1];
            if (xx <= x && yy <= y) {
                circle = Math.min(xx / totalR, yy / totalU);
                xx = xx - circle * totalR;
                yy = yy - circle * totalU;
                if (point.contains(xx + "-" + yy)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        robot("RRRUUU", new int[][]{{3, 0}}, 3, 3);
    }
}
