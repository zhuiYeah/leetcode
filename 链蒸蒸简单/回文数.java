package 链蒸蒸简单;

//阿里巴巴
public class 回文数 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int y = x;
        int z = 0;
        while (y > 0) {
            z = z * 10 + y % 10;
            y /= 10;
        }
        return x == z;
    }
}
