package 数学;

import java.util.ArrayList;
import java.util.List;

////计算n个矩形的面积（考虑重叠部分）
//扫描线算法，让人大开眼界
public class __几何_扫描线_矩形面积II {
    int MOD = (int) 1e9 + 7;

    public int rectangleArea(int[][] rectangles) {
        //xCoordinates会记录所有的x坐标,x坐标排序后会作为扫描线
        List<Integer> xCoordinates = new ArrayList<>();
        for (int[] x : rectangles) {
            xCoordinates.add(x[0]);
            xCoordinates.add(x[2]);
        }
        xCoordinates.sort((a, b) -> {
            return a - b;
        });
        long area = 0;
        for (int i = 1; i < xCoordinates.size(); i++) {
            //扫描线的左边和右边
            int left = xCoordinates.get(i - 1);
            int right = xCoordinates.get(i);
            if (right == left) continue;
            //yCoordinates存放所有坐落在该区间的y区间（上下）
            List<int[]> yCoordinates = new ArrayList<>();
            for (int[] rec : rectangles) {
                if (rec[0] <= left && rec[2] >= right) {
                    yCoordinates.add(new int[]{rec[1], rec[3]});
                }
            }
            //对y区间由小到大进行排序
            yCoordinates.sort((a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                } else {
                    return a[0] - b[0];
                }
            });
            long totalY = 0, down = -1, up = -1;
            for (int[] y : yCoordinates) {
                if (y[0] > up) { //和原来的区间完全无相交
                    totalY += (up - down);
                    down = y[0];
                    up = y[1];
                } else if (y[1] > up) { // 和原来的区间有相交并且超出了一部分
                    up = y[1];
                }
                //被原来的区间完全包含，那么什么都不用做
            }
            totalY += (up - down);
            area += totalY * (right - left);
            area %= MOD;
        }
        return (int) area;
    }
}


////////////////////////////////////////////////////////////////////////////////////////////////////////////
