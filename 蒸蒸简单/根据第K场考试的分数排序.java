package 蒸蒸简单;

import java.util.Arrays;

//语法题你写的这么复杂？
public class 根据第K场考试的分数排序 {
    public int[][] sortTheStudents(int[][] score, int k) {
        int m = score.length, n = score[0].length;
        Integer[] idx = new Integer[m];
        for (int i = 0; i < m; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> {
            return score[b][k] - score[a][k];
        });
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) res[i] = score[idx[i]];
        return res;
    }
}

class 一行 {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (a, b) -> b[k] - a[k]);
        return score;
    }
}
