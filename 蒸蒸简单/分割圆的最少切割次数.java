package 蒸蒸简单;

//将圆分割成 n等分的最小切割次数
public class 分割圆的最少切割次数 {
    public int numberOfCuts(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        if (n % 2 == 0) return n / 2;
        return n;
    }
}
