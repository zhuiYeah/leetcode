package DFS和BFS;

//将被X完全包围的O变为X  类似围棋
public class 被围绕的区域 {
    static int m;
    static int n;

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        //将与边缘的O能接触道到的O全部变为P
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        //将剩下来的O全部变为X
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        //将变为P的O还原
        for (int j = 0; j < n; j++) {
            restore(board, 0, j);
            restore(board, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            restore(board, i, 0);
            restore(board, i, n - 1);
        }

    }

    public void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O') return;
        board[i][j] = 'P';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }

    public void restore(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'P') return;
        board[i][j] = 'O';
        restore(board, i - 1, j);
        restore(board, i + 1, j);
        restore(board, i, j - 1);
        restore(board, i, j + 1);
    }
}