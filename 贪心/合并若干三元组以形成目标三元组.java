package 贪心;

import java.util.ArrayList;
import java.util.Arrays;

public class 合并若干三元组以形成目标三元组 {
//    public boolean mergeTriplets(int[][] triplets, int[] target) {
//        int num = target[0];
//        Arrays.sort(triplets, (a, b) -> {
//            return a[0] - b[0];
//        });
//        int i = -1;
//        for (i = triplets.length - 1; i >= 0; i--) {
//            if (triplets[i][0] == num) break;
//        }
//        if (i == -1) return false;
//        var list = new ArrayList<int[]>();
//        for (int k = 0; k <= i; k++) {
//            list.add(triplets[i]);
//        }
//        for ( i = 0;i<list.size();i++) {
//            if ()
//        }
//    }
}


//// 贪心 合并尽可能多的三元组
class dwdw {
    public boolean mergeTriplets(int[][] triplets, int[] target) {

        var list = new ArrayList<int[]>(Arrays.asList(triplets));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[0] > target[0] || list.get(i)[1] > target[1] || list.get(i)[2] > target[2]) {
                list.remove(i);
                i--;
            }
        }
        boolean c1 = false, c2 = false, c3 = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[0] == target[0]) c1 = true;
            if (list.get(i)[1] == target[1]) c2 = true;
            if (list.get(i)[2] == target[2]) c3 = true;
        }
        return c1 && c2 && c3;
    }
}
