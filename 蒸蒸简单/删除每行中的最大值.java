package 蒸蒸简单;

public class 删除每行中的最大值 {
    public int deleteGreatestValue(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for (int k = 0; k < n; k++) {
            int thismax = 0;
            for (int i = 0; i < m; i++) {
                int maxid = -1;
                int max = 0;
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] > max) {
                        maxid = j;
                        max = grid[i][j];
                    }
                }
                thismax = Math.max(max, thismax);
                grid[i][maxid] = -1;
            }
            res += thismax;
        }
        return res;
    }
}