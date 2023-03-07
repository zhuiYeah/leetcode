package 二分查找;

import java.util.ArrayList;
import java.util.List;


abstract class CustomFunction {
    // Returns f(x, y) for any given positive integers x and y.
    // Note that f(x, y) is increasing with respect to both x and y.
    // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
    public abstract int f(int x, int y);
}

public class 找出给定方程的正整数解 {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        var res = new ArrayList<List<Integer>>();
        boolean flag = false;
        for (int x = 1; x <= 1000; x++) {
            int l = 1, r = 1000;
            while (l <= r) {
                if (customfunction.f(x, 1) > z) {
                    flag = true;
                    break;
                }
                int mid = l + (r - l) / 2;
                int val = customfunction.f(x, mid);
                if (val == z) {
                    var list = new ArrayList<Integer>();
                    list.add(x);
                    list.add(mid);
                    res.add(list);
                    break;
                } else if (val > z) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            if (flag) break;
        }
        return res;
    }
}
