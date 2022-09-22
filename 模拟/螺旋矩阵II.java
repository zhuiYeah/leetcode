package 模拟;

//以递归的方式进行模拟

public class 螺旋矩阵II {
    static int[][] mat;

    public static int[][] generateMatrix(int n) {
        mat = new int[n][n];
        mat[0][0] = 1;
        //我目前在（0，0）位置，我下一个要填入的数字是2，接下来怎么走交给你了
        nextStep(0, 0, 2);
        return mat;
    }

    public static void nextStep(int row, int col, int nextNum) {
        int n = mat.length;
        if (col + 1 < n && mat[row][col + 1] == 0) {
            int j = col + 1;
            for (j = col + 1; j < n && mat[row][j] == 0; j++) {
                mat[row][j] = nextNum++;
            }

            nextStep(row, j - 1, nextNum);
        }
        if (row + 1 < n && mat[row + 1][col] == 0) {
            int i = row + 1;
            for (; i < n && mat[i][col] == 0; i++) {
                mat[i][col] = nextNum++;
            }
            nextStep(i - 1, col, nextNum);
        }
        if (col - 1 >= 0 && mat[row][col - 1] == 0) {
            int j = col - 1;
            for (; j >= 0 && mat[row][j] == 0; j--) {
                mat[row][j] = nextNum++;
            }
            nextStep(row, j + 1, nextNum);
        }
        if (row - 1 >= 0 && mat[row - 1][col] == 0) {
            int i = row - 1;
            for (; i >= 0 && mat[i][col] == 0; i--) {
                mat[i][col] = nextNum++;
            }
            nextStep(i + 1, col, nextNum);
        }
    }

    public static void main(String[] args) {
        generateMatrix(3);
    }
}
