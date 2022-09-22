package DFS和BFS;

public class dfs扫雷游戏 {
    int m;
    int n;
    char[][] board;
    int[][] dirs = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        m = board.length;
        n = board[0].length;
        this.board = board;
        int row = click[0];
        int col = click[1];
        //刚好踩雷，那么雷爆炸，游戏结束,M表示当前位置是个未踩的雷
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return board;
        }
        dfs(row, col);
        return this.board;
        //return board;

    }

    public void dfs(int row, int col) {
        //dfs只处理未挖空块
        if (row < 0 || col < 0 || row >= m || col >= n || board[row][col] != 'E') {
            return;
        }
        //计算该未挖空块四(8)周的地雷个数
        int count = 0;
        for (int[] x : dirs) {
            int curRow = x[0] + row;
            int curCol = x[1] + col;
            if (curRow >= 0 && curCol >= 0 && curRow < m && curCol < n && board[curRow][curCol] == 'M') {
                count++;
            }
        }
        if (count == 0) {
            //标记为四周没有地雷的已挖空块
            board[row][col] = 'B';
        } else {
            //标记为四周有count个雷的已挖空块
            board[row][col] = String.valueOf(count).charAt(0);
        }

        if (count == 0) {
            dfs(row - 1, col);
            dfs(row + 1, col);
            dfs(row, col - 1);
            dfs(row, col + 1);
            dfs(row - 1, col - 1);
            dfs(row - 1, col + 1);
            dfs(row + 1, col - 1);
            dfs(row + 1, col + 1);
        }
    }

    public static void main(String[] args) {
        int count = 8;
        String xx = String.valueOf(count);
        char x = xx.charAt(0);
        System.out.println(x);
    }
}
