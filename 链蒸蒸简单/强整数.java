package 链蒸蒸简单;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 强整数 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> res = new ArrayList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 20; j++) {
                int a = (int) Math.pow(x, i), b = (int) Math.pow(y, j);
                if (a + b > bound || a + b <= 0) continue;
                set.add(a + b);
            }
        }
        res.addAll(set);
        return res;
    }
}
