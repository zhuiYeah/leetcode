package 链蒸蒸简单;

public class 将一维数组转化为二维数组 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) {
            return new int[][]{};
        }
        var result = new int[m][n];
        int row = 0, col = 0;
        for (int i = 0; i < original.length; i++) {
            result[row][col] = original[i];
            col++;
            if (col == n) {
                col = 0;
                row++;
            }
        }
        return result;
    }
}
