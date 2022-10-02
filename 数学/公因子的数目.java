package 数学;

//313场周赛 辗转相除法
public class 公因子的数目 {
    public int commonFactors(int a, int b) {
        while (a%b != 0) {
            var tmp = a % b;
            a = b;
            b = tmp;
        }
        int count = 0;
        for (int i = 1 ; i<=b ;i++){
            if (b % i ==0)  count ++;
        }
        return count;
    }
}
