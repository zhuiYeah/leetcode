package 模拟;

import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵 {
    List<Integer> res;
    int[][] matrix;
    int m;
    int n;

    public List<Integer> spiralOrder(int[][] matrix) {
        res  = new ArrayList<Integer>();
        res.add(matrix[0][0]);
        this.matrix = matrix;
        matrix[0][0] = 114514;
        m = matrix.length;
        n = matrix[0].length;
        next(0, 0);
        return res;
    }

    //我当前在 row col 位置 ，接下来怎么走交给你了
    public void next(int row, int col) {
        if (col + 1 < n && matrix[row][col + 1] != 114514) {
            int j = col + 1;
            for (; j < n && matrix[row][j] != 114514; j++) {
                res.add(matrix[row][j]);
                matrix[row][j] = 114514;
            }
            next(row, j - 1);
        }
        if (row + 1 < m && matrix[row + 1][col] != 114514) {
            int i = row + 1;
            for (; i < m && matrix[i][col] != 114514; i++) {
                res.add(matrix[i][col]);
                matrix[i][col] = 114514;
            }
            next(i - 1, col);
        }
        if (col - 1 >= 0 && matrix[row][col - 1] != 114514) {
            int j = col - 1;
            for (; j >= 0 && matrix[row][j] != 114514; j--) {
                res.add(matrix[row][j]);
                matrix[row][j] = 114514;
            }
            next(row, j + 1);
        }
        if (row - 1 >= 0 && matrix[row - 1][col] != 114514) {
            int i = row - 1;
            for (; i >= 0 && matrix[i][col] != 114514; i--) {
                res.add(matrix[i][col]);
                matrix[i][col] = 114514;
            }
            next(i + 1, col);
        }
    }
}
