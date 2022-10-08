package DFS和BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 水域大小 {
    int[][] land;
    int m;
    int n;

    public int[] pondSizes(int[][] land) {
        this.land = land;
        m = land.length;
        n = land[0].length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 0) {
                    list.add(dfs(i, j));
                }
            }
        }
        int[] res = new int[list.size()];
        //这里好麻烦 不呢个直接把list转为int型数组
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        Arrays.sort(res); //对数组的排序要比对list的排序更快一些
        return res;
    }

    public int dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n || land[i][j] != 0) {
            return 0;
        }
        land[i][j] = 114514;
        return dfs(i - 1, j - 1) + dfs(i - 1, j) + dfs(i - 1, j + 1) + dfs(i, j - 1) +
                dfs(i, j + 1) + dfs(i + 1, j - 1) + dfs(i + 1, j) + dfs(i + 1, j + 1) + 1;
    }
}
