package 数组;

public class 判断矩阵经轮转后是否一致 {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        boolean rot1 = true, rot2 = true, rot3 = true, rot4 = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = target[i][j];
                if (num != mat[i][j]) rot1 = false;
                if (num != mat[n - j - 1][i]) rot2 = false;
                if (num != mat[n - i - 1][n - j - 1]) rot3 = false;
                if (num != mat[j][n - i - 1]) rot4 = false;
            }
        }
        return rot1 || rot2 || rot3 || rot4;
    }
}
