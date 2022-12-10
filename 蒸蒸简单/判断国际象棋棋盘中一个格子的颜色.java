package 蒸蒸简单;

public class 判断国际象棋棋盘中一个格子的颜色 {
    public boolean squareIsWhite(String coordinates) {
        int x = coordinates.charAt(0);
        int y = coordinates.charAt(1);
        if (x % 2 == 0) {
            return y % 2 == 1;
        } else {
            return y % 2 == 0;
        }
    }
}
