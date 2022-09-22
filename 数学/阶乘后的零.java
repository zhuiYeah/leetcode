package 数学;

public class 阶乘后的零 {
    int res;

    public int trailingZeroes(int n) {
        for (int i = 5; i <= n; i += 5) {
            for (int x = i; x % 5 == 0; x /= 5) {
                res++;
            }
        }
        return res;
    }
}


////////////////////////////////////////////////////////////////////////
class Solution1 {

    public int trailingZeroes(int x) {
        long res = 0;
        while (x != 0) {
            res += x / 5;
            x /= 5;
        }
        return (int) res;
    }
}