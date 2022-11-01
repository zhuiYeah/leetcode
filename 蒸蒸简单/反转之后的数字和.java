package 蒸蒸简单;

//315场周赛

//是否存在一个数字 ， 这个数字 + 这个数字倒过来 == num ，则返回true；

//暴力
public class 反转之后的数字和 {
    public boolean sumOfNumberAndReverse(int num) {
        for (int i = 0; i <= num; i++) {
            if (i + reverse(i) == num) return true;
        }
        return false;
    }

    public int reverse(int num) {
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
}
