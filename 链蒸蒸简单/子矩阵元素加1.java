package 链蒸蒸简单;

public class 子矩阵元素加1 {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat = new int[n][n];
        for (int[] q : queries) {
            int up = q[0], l = q[1], down = q[2], r = q[3];
            for (int i = up; i <= down; i++) {
                for (int j = l; j <= r; j++) {
                    mat[i][j]++;
                }
            }
        }
        return mat;
    }
}
