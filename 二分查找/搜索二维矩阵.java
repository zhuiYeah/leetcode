package 二分查找;

//两次二分查找，一次搜索行，一次搜索列
//时间复杂度：O(log m+log n)=O(log mn)
//其中 mm 和 nn 分别是矩阵的行数和列数。
public class 搜索二维矩阵 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = Integer.MAX_VALUE;
        int up = 0, down = m - 1;
        while (up <= down) {
            int mid = up + (down - up) / 2;
            if (matrix[mid][0] > target) { //target不可能在第mid行
                down = mid - 1;
            } else if (matrix[mid][0] < target) { //target有可能在mid行，也有可能在mid之后的行
                row = mid;
                up = mid + 1;
            } else {
                return true;
            }
        }
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] > target) {
                right = mid - 1;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        searchMatrix(matrix, 3);
    }
}
