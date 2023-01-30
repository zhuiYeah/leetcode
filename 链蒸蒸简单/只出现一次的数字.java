package 链蒸蒸简单;

import java.util.HashMap;
import java.util.Map;

public class 只出现一次的数字 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 114514;
    }
}
