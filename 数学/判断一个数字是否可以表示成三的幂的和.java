package 数学;


//3进制    贪心
public class 判断一个数字是否可以表示成三的幂的和 {
    public boolean checkPowersOfThree(int n) {
        //i表示3的i次方
        int i = 23;
        while (n > 0 && i >= 0) {
            while (Math.pow(3.0, i) > n) i--;
            n -= Math.pow(3.0, i);
            //每个次方只能用一次哦
            i--;
        }
        return n == 0;
    }
}

