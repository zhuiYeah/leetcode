package 链蒸蒸简单;

import java.util.HashMap;

public class 出现最频繁的偶数元素 {
    public int mostFrequentEven(int[] nums) {
        int res = -1;
        int maxfre = 0;
        var cnt = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (num % 2 ==1) continue;
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
            if (cnt.get(num) == maxfre && num< res || cnt.get(num) >maxfre) {
                res = num;
                maxfre = cnt.get(num);
            }
        }
        return res;
    }
}
