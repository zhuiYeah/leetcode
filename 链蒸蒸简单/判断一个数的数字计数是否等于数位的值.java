package 链蒸蒸简单;

import java.util.HashMap;

public class 判断一个数的数字计数是否等于数位的值 {
    public boolean digitCount(String num) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < num.length(); i++) map.put(num.charAt(i)-'0', map.getOrDefault(num.charAt(i)-'0', 0) + 1);
        for (int i = 0; i < num.length(); i++) {
            int inFactAppear = map.getOrDefault(i, 0);
            int shouldAppear = num.charAt(i) - '0';
            if (shouldAppear != inFactAppear) return false;
        }
        return true;
    }
}
