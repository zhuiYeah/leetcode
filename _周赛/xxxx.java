package _周赛;

public class xxxx {
    public double[][] Pixel_Merge(int m, int n, double[][] graph) {
        // ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int row = graph.length, col = graph[0].length;

        // 记录某一区块的总和
        double[][] res = new double[row % m == 0 ? row / m : row / m + 1][col % n == 0 ? col / n : col / n + 1];
        // 记录某一区块的总计数
        int[][] cnt = new int[row % m == 0 ? row / m : row / m + 1][col % n == 0 ? col / n : col / n + 1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int ni = i / m, nj = j / n;
                res[ni][nj] += graph[i][j];
                cnt[ni][nj]++;
            }
        }

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++)
                res[i][j] /= cnt[i][j];
        }

        return res;
    }
}
