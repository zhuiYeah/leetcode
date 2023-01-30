package 链蒸蒸简单;

import java.util.HashMap;
import java.util.Map;

public class 盒子中小球的最大数量 {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int bucket = getBucket(i);
            map.put(bucket, map.getOrDefault(bucket, 0) + 1);
            max = Math.max(max, map.get(bucket));
        }
        return max;
    }

    private int getBucket(int x) {
        int res = 0;
        while (x > 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}
