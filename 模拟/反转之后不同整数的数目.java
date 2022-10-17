package 模拟;

import java.util.HashSet;
import java.util.Set;
//315场周赛 秒杀

public class 反转之后不同整数的数目 {
    public static int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
            set.add(reverse(num));
        }
        return set.size();
    }

    public static int reverse(int num) {
        String s = String.valueOf(num);
        char[] c = s.toCharArray();
        int n = c.length;
        for (int i = 0; i < c.length / 2; i++) {
            var tmp = c[i];
            c[i] = c[n - 1 - i];
            c[n - 1 - i] = tmp;
        }
        s = new String(c);
        return Integer.parseInt(s);
    }

    public static  void main(String[] args){
        countDistinctIntegers(new int []{1,13,10,12,31});
    }
}
