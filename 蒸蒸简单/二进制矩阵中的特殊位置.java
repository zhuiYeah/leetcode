package 蒸蒸简单;

//O(m*n)
public class 二进制矩阵中的特殊位置 {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] countRow = new int[m]; // countRow[i]:第i行中1的个数
        int[] countCol = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    countRow[i]++;
                    countCol[j]++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && countCol[j] == 1 && countRow[i] == 1) {
                    res++;
                }
            }
        }
        return res;
    }

}
