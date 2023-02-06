package 链蒸蒸简单;

import java.util.ArrayList;

public class 分割数组中数字的数位 {
    public int[] separateDigits(int[] nums) {
        var arr = new ArrayList<Integer>();
        for (int i : nums) {
            var x = new ArrayList<Integer>();
            while (i > 0) {
                x.add(0, i % 10);
                i /= 10;
            }
            arr.addAll(x);
        }
        int[] res = new int[arr.size()];
        for (int i = 0; i < res.length; i++) res[i] = arr.get(i);
        return res;
    }
}
