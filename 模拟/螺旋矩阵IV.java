package 模拟;

//递归实现模拟
public class 螺旋矩阵IV {
    int m;
    int n;
    ListNode head;
    int[][] mat;
    boolean[][] visited;

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        this.m = m;
        this.n = n;
        this.head = head.next;
        mat = new int[m][n];
        visited = new boolean[m][n];
        mat[0][0] = head.val;
        visited[0][0] = true;
        nextStep(0, 0);
        return mat;
    }

    public void nextStep(int row, int col) {
        if (col + 1 < n && !visited[row][col + 1]) {
            int j = col + 1;
            for (; j < n && !visited[row][j]; j++) {
                visited[row][j] = true;
                if (head != null) {
                    mat[row][j] = head.val;
                    head = head.next;
                } else {
                    mat[row][j] = -1;
                }
            }
            nextStep(row, j - 1);
        }
        if (row + 1 < m && !visited[row + 1][col]) {
            int i = row + 1;
            for (; i < m && !visited[i][col]; i++) {
                visited[i][col] = true;
                if (head != null) {
                    mat[i][col] = head.val;
                    head = head.next;
                } else {
                    mat[i][col] = -1;
                }
            }
            nextStep(i - 1, col);
        }

        if (col - 1 >= 0 && !visited[row][col - 1]) {
            int j = col - 1;
            for (; j >= 0 && !visited[row][j]; j--) {
                visited[row][j] = true;
                if (head == null) {
                    mat[row][j] = -1;
                } else {
                    mat[row][j] = head.val;
                    head = head.next;
                }
            }
            nextStep(row, j + 1);
        }
        if (row - 1 >= 0 && !visited[row - 1][col]) {
            int i = row - 1;
            for (; i >= 0 && !visited[i][col]; i--) {
                visited[i][col] = true;
                mat[i][col] = head == null ? -1 : head.val;
                if (head != null) {
                    head = head.next;
                }
            }
            nextStep(i + 1, col);
        }
    }
}
