package 模拟;

import java.util.HashMap;
import java.util.Map;

public class 数青蛙 {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int res = 0, frogNum = 0;
        int n = croakOfFrogs.length();
        if (n % 5 != 0) return -1;
        int[] cnt = new int[4];
        Map<Character, Integer> map = new HashMap<Character, Integer>() {{
            put('c', 0);
            put('r', 1);
            put('o', 2);
            put('a', 3);
            put('k', 4);
        }};
        for (int i = 0 ; i < n ; i++){
            char c = croakOfFrogs.charAt(i);
            int t = map.get(c);
            if (t == 0) {
                cnt[t]++;
                frogNum++;

            }
        }
        return 0 ;
    }
}
