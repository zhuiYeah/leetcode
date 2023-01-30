package 链蒸蒸简单;

import java.util.Arrays;

public class 判定是否互为字符重排 {
    public boolean CheckPermutation(String s1, String s2) {
        var charS1 = s1.toCharArray();
        var charS2 = s2.toCharArray();
        Arrays.sort(charS2);
        Arrays.sort(charS1);
        s1 = new String(charS1);
        s2 = new String(charS2);
        return s1.equals(s2);
    }
}
