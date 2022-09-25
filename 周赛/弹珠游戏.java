package 周赛;

import java.util.ArrayList;

//周赛错误提交了9次才写出来的
public class 弹珠游戏 {
    ArrayList<int[]> res = new ArrayList<int[]>();
    int m;
    int n;
    String[] plate;

    public int[][] ballGame(int num, String[] plate) {
        m = plate.length;
        n = plate[0].length();
        this.plate = plate;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (plate[i].charAt(j) == 'O') {
                    dfs(i - 1, j, "up", num - 1);
                    dfs(i + 1, j, "down", num - 1);
                    dfs(i, j - 1, "left", num - 1);
                    dfs(i, j + 1, "right", num - 1);
                }
            }
        }
        int[][] result = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public void dfs(int row, int col, String dir, int steps) {
        //越界
        if (row < 0 || col < 0 || row >= m || col >= n) return;

        //if (row > 0 && row < m - 1 && col > 0 && col < n - 1) return;
        //到达四个角
        //if ((row == 0 || row == m - 1) && (col == 0 || col == n - 1)) return;
        //到达边上的落脚点
        if (row == 0 || row == m - 1 || col == 0 || col == n - 1) {
            if (plate[row].charAt(col) == '.') {
                if (dir.equals("left") && col == 0 || dir.equals("right") && col == n - 1 || dir.equals("up") && row == 0 || dir.equals("down") && row == m - 1) {
                    if (!((row == 0 || row == m - 1) && (col == 0 || col == n - 1))) {
                        res.add(new int[]{row, col});
                        return;
                    }
                }
            }
        }
        //步数用完
        if (steps == 0) return;

        if (dir.equals("up")) {
            if (plate[row].charAt(col) == '.') {
                dfs(row - 1, col, "up", steps - 1);
            } else if (plate[row].charAt(col) == 'E') {
                dfs(row, col - 1, "left", steps - 1);
            } else if (plate[row].charAt(col) == 'W') {
                dfs(row, col + 1, "right", steps - 1);
            }
        } else if (dir.equals("down")) {
            if (plate[row].charAt(col) == '.') {
                dfs(row + 1, col, "down", steps - 1);
            } else if (plate[row].charAt(col) == 'E') {
                dfs(row, col + 1, "right", steps - 1);
            } else if (plate[row].charAt(col) == 'W') {
                dfs(row, col - 1, "left", steps - 1);
            }
        } else if (dir.equals("left")) {
            if (plate[row].charAt(col) == '.') {
                dfs(row, col - 1, "left", steps - 1);
            } else if (plate[row].charAt(col) == 'E') {
                dfs(row + 1, col, "down", steps - 1);
            } else if (plate[row].charAt(col) == 'W') {
                dfs(row - 1, col, "up", steps - 1);
            }
        } else if (dir.equals("right")) {
            if (plate[row].charAt(col) == '.') {
                dfs(row, col + 1, "right", steps - 1);
            } else if (plate[row].charAt(col) == 'E') {
                dfs(row - 1, col, "up", steps - 1);
            } else if (plate[row].charAt(col) == 'W') {
                dfs(row + 1, col, "down", steps - 1);
            }
        }
    }

}
