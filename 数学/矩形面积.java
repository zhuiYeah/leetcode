package 数学;

public class 矩形面积 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int areaX = (ax2 - ax1) * (ay2 - ay1);
        int areaY = (by2 - by1) * (bx2 - bx1);
        if (ax2 <= bx1 || bx2 <= ax1 || ay2 <= by1 || by2 <= ay1) {
            return areaX + areaY;
        }
        int left = Math.max(ax1, bx1);
        int right = Math.min(ax2, bx2);
        int down = Math.max(ay1, by1);
        int up = Math.min(ay2, by2);
        int overlapping = (right - left) * (up - down);
        return areaX - overlapping + areaY;
    }
}
