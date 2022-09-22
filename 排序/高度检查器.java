package 排序;

import java.util.Arrays;

import static java.util.Arrays.sort;

public class 高度检查器 {
    public static int heightChecker(int[] heights) {
        int res = 0;
        int[] copy = heights.clone(); //深复制数组！
        Arrays.sort(copy);
        for (int i = 0; i < copy.length; i++) {
            if (heights[i] != copy[i]) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        heightChecker(arr);
    }
}

