package 贪心;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//贪心 + 排序
//本质上是一道区间排序的题目
public class 划分字母区间 {
    public List<Integer> partitionLabels(String s) {
        int[][] quJian = new int[26][2];
        for (int[] ints : quJian) {
            Arrays.fill(ints, -1);
        }
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (quJian[index][0] == -1) {
                quJian[index][0] = i;
                quJian[index][1] = i;
            } else {
                quJian[index][1] = i;
            }
        }
        Arrays.sort(quJian, (a, b) -> {
            return a[0] - b[0];
        });
        int ptr = 0;
        while (quJian[ptr][0] == -1) {
            ptr++;
        }
        List<Integer> res = new ArrayList<>();
        int start = quJian[ptr][0], end = quJian[ptr][1];
        for (int i = ptr + 1; i < 26; i++) {
            if (quJian[i][0] == end + 1) {
                res.add(end - start + 1);
                start = quJian[i][0];
                end = quJian[i][1];
            } else if (quJian[i][1] > end) {
                end = quJian[i][1];
            }
        }
        res.add(end - start + 1);
        return res;
    }
}
