package 回溯;

public class 单词搜索 {

    String word;
    int m;
    int n;
    char[][] board;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtracking(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtracking(int i, int j, int curIndex) {
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != word.charAt(curIndex)) {
            return false;
        }
        if (curIndex == word.length() - 1) {
            return true;
        }
        char tmp = board[i][j];
        board[i][j] = 0;
        if (backtracking(i - 1, j, curIndex + 1) || backtracking(i + 1, j, curIndex + 1) || backtracking(i, j - 1, curIndex + 1) || backtracking(i, j + 1, curIndex + 1))
            return true;
        board[i][j] = tmp;
        return false;
    }
}


class dwederwe {
    int m;
    int n;
    char[][] board;
    String word;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        m = board.length;
        n = board[0].length;
        this.word = word;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtracking(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtracking(int i, int j, int curIndex) {
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != word.charAt(curIndex)) {
            return false;
        }
        if (curIndex == word.length() - 1) {
            return true;
        }
        char tmp = board[i][j];
        board[i][j] = '*';
        if (backtracking(i + 1, j, curIndex + 1) || backtracking(i - 1, j, curIndex + 1) || backtracking(i, j - 1, curIndex + 1) || backtracking(i, j + 1, curIndex + 1)) {
            return true;
        }
        board[i][j] = tmp;
        return false;
    }
}
