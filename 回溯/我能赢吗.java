package 回溯;

public class 我能赢吗 {
    static boolean[] used;
    static int desiredTotalx;
    static int maxChoosableIntegerX;

    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        used = new boolean[maxChoosableInteger + 1];
        desiredTotalx = desiredTotal;
        if (desiredTotal == 0) return true;
        maxChoosableIntegerX = maxChoosableInteger;
        return backtracking(0, 1);
    }

    //curSum表示上一个玩家选完的总和，who表示上一个玩家
    public static boolean backtracking(int curSum, int player) {
        if (curSum >= desiredTotalx && player == 0) return true;
        if (curSum >= desiredTotalx && player == 1) return false;
        for (int i = maxChoosableIntegerX; i >= 1; i--) {
            if (!used[i]) {
                used[i] = true;
                if (backtracking(curSum + i, player ^ 1)) return true;
                used[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        canIWin(10, 11);
    }
}


class dxewcdewc{
     boolean[] used;
     int desiredTotalx;
     int maxChoosableIntegerX;

    public  boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        used = new boolean[maxChoosableInteger + 1];
        desiredTotalx = desiredTotal;
        if (desiredTotal == 0) return true;
        maxChoosableIntegerX = maxChoosableInteger;
        return backtracking(0, 1);
    }

    //curSum表示上一个玩家选完的总和，who表示上一个玩家
    public  boolean backtracking(int curSum, int player) {
        if (curSum >= desiredTotalx && player == 0) return true;
        if (curSum >= desiredTotalx && player == 1) return false;
        for (int i = maxChoosableIntegerX; i >= 1; i--) {
            if (!used[i]) {
                used[i] = true;
                if (backtracking(curSum + i, player ^ 1)) return true;
                used[i] = false;
            }
        }
        return false;
    }
}
